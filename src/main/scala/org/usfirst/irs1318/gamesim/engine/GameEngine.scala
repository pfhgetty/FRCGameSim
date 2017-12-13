package org.usfirst.irs1318.gamesim.engine

import java.time.Instant

import org.usfirst.irs1318.gamesim.engine.actions.Action
import org.usfirst.irs1318.gamesim.engine.actors.Field
import org.usfirst.irs1318.gamesim.engine.event.{EventLog, EventQueue}
import org.usfirst.irs1318.gamesim.engine.objective.DependencyManager
import org.usfirst.irs1318.gamesim.game.{Match, MatchResult}

case class GameEngine(implicit interpreter: GameEngine.Interpreter) {
  def playMatch(`match`: Match): MatchResult = ???
}

object GameEngine {
  case class State(time: Instant,
                   field: Field,
                   eventQueue: EventQueue,
                   dependencyManager: DependencyManager,
                   eventLog: EventLog)

  type Interpreter = org.usfirst.irs1318.gamesim.interpret.Interpreter[Action, GameEngine.State]
}
