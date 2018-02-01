package org.usfirst.irs1318.gamesim.engine.action

import org.usfirst.irs1318.gamesim.engine.GameEngine

case class ChangePhase(phase: GameEngine.State.Phase) extends Action {
  override def run(state: GameEngine.State): GameEngine.State = state.mapPhase(_ => phase)
}
