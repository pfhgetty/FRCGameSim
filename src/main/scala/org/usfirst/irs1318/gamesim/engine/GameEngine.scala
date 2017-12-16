package org.usfirst.irs1318.gamesim.engine

import org.usfirst.irs1318.gamesim.engine.actions.Action
import org.usfirst.irs1318.gamesim.engine.actors.{Field, Location}
import org.usfirst.irs1318.gamesim.engine.event.{Event, EventLog, EventQueue}
import org.usfirst.irs1318.gamesim.engine.interpret.DefaultGameEngineInterpreter
import org.usfirst.irs1318.gamesim.engine.objective.DependencyManager
import org.usfirst.irs1318.gamesim.game.{Match, MatchResult}

import scala.annotation.tailrec

case class GameEngine(interpreter: GameEngine.Interpreter) {
  def playMatch(`match`: Match): MatchResult = ???

  @tailrec final def simulateState(state: GameEngine.State): GameEngine.State = {
    simulateNextEvent(state) match {
      case None => state
      case Some(newState) => simulateState(newState)
    }
  }

  def simulateNextEvent(state: GameEngine.State): Option[GameEngine.State] = {
    state.eventQueue.pop().map { case (event, newEventQueue) =>
      simulateEvent(event, state.mapEventQueue(_ => newEventQueue))
    }
  }

  def simulateEvent(event: Event, state: GameEngine.State): GameEngine.State =
    interpreter.run(event.action, state.mapTime(_ => event.time))
}

object GameEngine {
  case class State(time: Long,
                   field: Field,
                   eventQueue: EventQueue,
                   dependencyManager: DependencyManager,
                   eventLog: EventLog) {
    @inline def mapTime(fn: Long => Long): State = copy(time = fn(time))
    @inline def mapField(fn: Field => Field): State = copy(field = fn(field))
    @inline def mapEventQueue(fn: EventQueue => EventQueue): State = copy(eventQueue = fn(eventQueue))
    @inline def mapDependencyManager(fn: DependencyManager => DependencyManager): State = copy(dependencyManager = fn(dependencyManager))
    @inline def mapEventLog(fn: EventLog => EventLog): State = copy(eventLog = fn(eventLog))
  }

  object State {
    case class Builder(state: State) {
      def this() = this(State(0, new Field.Builder().build, EventQueue(), DependencyManager(), EventLog.empty))
      @inline def mapState(fn: State => State): Builder = copy(state = fn(state))
      def setTime(time: Long): Builder = mapState(_.mapTime(_ => time))
      def setField(field: Field): Builder = mapState(_.mapField(_ => field))
      def setEventQueue(eventQueue: EventQueue): Builder = mapState(_.mapEventQueue(_ => eventQueue))
      def setDependencyManager(dependencyManager: DependencyManager): Builder = mapState(_.mapDependencyManager(_ => dependencyManager))
      def setEventLog(eventLog: EventLog): Builder = mapState(_.mapEventLog(_ => eventLog))
      def addEvent(event: Event): Builder = mapState(_.mapEventQueue(_ + event))
      def addLogEntry(entry: EventLog.Entry): Builder = mapState(_.mapEventLog(_ + entry))
      def build: State = state
    }
  }

  type Interpreter = org.usfirst.irs1318.gamesim.interpret.Interpreter[Action, GameEngine.State]
}
