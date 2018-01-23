package org.usfirst.irs1318.gamesim.engine.action

import org.usfirst.irs1318.gamesim.engine.GameEngine
import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails

trait Action {
  def taskDetails: TaskDetails
  def run(state: GameEngine.State): GameEngine.State
}
