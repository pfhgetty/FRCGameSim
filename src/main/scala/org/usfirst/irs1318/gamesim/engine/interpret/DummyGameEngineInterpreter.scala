package org.usfirst.irs1318.gamesim.engine.interpret

import org.usfirst.irs1318.gamesim.engine.GameEngine
import org.usfirst.irs1318.gamesim.engine.actions.Action

case class DummyGameEngineInterpreter() extends GameEngine.Interpreter {
  override def run(action: Action, state: GameEngine.State): GameEngine.State = state
}
