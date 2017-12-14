package org.usfirst.irs1318.gamesim.engine

import java.time.Instant

import org.usfirst.irs1318.gamesim.engine.actions.Action
import org.usfirst.irs1318.gamesim.engine.actors.Field
import org.usfirst.irs1318.gamesim.engine.event.{Event, EventLog, EventQueue}
import org.usfirst.irs1318.gamesim.engine.objective.DependencyManager
import org.usfirst.irs1318.gamesim.game.{Match, MatchResult}

import scala.annotation.tailrec

class GameEngine(private implicit val interpreter: GameEngine.Interpreter) {
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

  def simulateEvent(event: Event, state: GameEngine.State): GameEngine.State = interpreter.run(event.action, state)
}

object GameEngine {
  case class State(time: Instant,
                   field: Field,
                   eventQueue: EventQueue,
                   dependencyManager: DependencyManager,
                   eventLog: EventLog) {
    @inline def mapTime(fn: Instant => Instant): State = copy(time = fn(time))
    @inline def mapField(fn: Field => Field): State = copy(field = fn(field))
    @inline def mapEventQueue(fn: EventQueue => EventQueue): State = copy(eventQueue = fn(eventQueue))
    @inline def mapDependencyManager(fn: DependencyManager => DependencyManager): State = copy(dependencyManager = fn(dependencyManager))
    @inline def mapEventLog(fn: EventLog => EventLog): State = copy(eventLog = fn(eventLog))
  }

  type Interpreter = org.usfirst.irs1318.gamesim.interpret.Interpreter[Action, GameEngine.State]
}
