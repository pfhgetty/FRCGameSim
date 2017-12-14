package org.usfirst.irs1318.gamesim.engine.interpret

import org.usfirst.irs1318.gamesim.engine.GameEngine
import org.usfirst.irs1318.gamesim.engine.actions.Action
import org.usfirst.irs1318.gamesim.engine.actions.Action._

case class DefaultGameEngineInterpreter() extends GameEngine.Interpreter {
  override def run(action: Action, state: GameEngine.State): GameEngine.State = action match {
    case ChangePhase(phase, _, taskDetails) => state.mapField(field => field.copy(phase = phase))
    case Move(direction, actor, taskDetails) => ???
    case Defend(target, actor, taskDetails) => ???
    case Pick(source, failure, actor, taskDetails) => ???
    case Place(dest, failure, actor, taskDetails) => ???
    case Shoot(dest, failure, actor, taskDetails) => ???
  }
}
