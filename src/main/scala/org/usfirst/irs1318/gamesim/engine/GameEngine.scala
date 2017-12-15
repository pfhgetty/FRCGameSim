package org.usfirst.irs1318.gamesim.engine

import org.usfirst.irs1318.gamesim.engine.actions.Action
import org.usfirst.irs1318.gamesim.engine.actors.{Field, Location}
import org.usfirst.irs1318.gamesim.engine.event.{Event, EventLog, EventQueue}
import org.usfirst.irs1318.gamesim.engine.interpret.DefaultGameEngineInterpreter
import org.usfirst.irs1318.gamesim.engine.objective.DependencyManager
import org.usfirst.irs1318.gamesim.game.{Match, MatchResult}

import scala.annotation.tailrec

class GameEngine(val interpreter: GameEngine.Interpreter) {
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
    def empty: State = State(
      0,
      Field(0, 0, Field.Phase.PRE, Location(0, 0), Map.empty),
      EventQueue(),
      new DependencyManager(),
      EventLog.empty
    )
  }

  def instance: GameEngine = new GameEngine(DefaultGameEngineInterpreter.instance)

  type Interpreter = org.usfirst.irs1318.gamesim.interpret.Interpreter[Action, GameEngine.State]
}
