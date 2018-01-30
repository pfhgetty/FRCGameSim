package org.usfirst.irs1318.gamesim.engine.action

import org.usfirst.irs1318.gamesim.engine.GameEngine
import org.usfirst.irs1318.gamesim.engine.actors.Field
import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails

case class ChangePhase(phase: Field.Phase, taskDetails: TaskDetails) extends Action {
  override def run(state: GameEngine.State): GameEngine.State = state.mapField(_.mapPhase(_ => phase))
}
