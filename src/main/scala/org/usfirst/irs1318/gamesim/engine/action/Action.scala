package org.usfirst.irs1318.gamesim.engine.action

import org.usfirst.irs1318.gamesim.engine.GameEngine

trait Action {
  def run(state: GameEngine.State): GameEngine.State
}
