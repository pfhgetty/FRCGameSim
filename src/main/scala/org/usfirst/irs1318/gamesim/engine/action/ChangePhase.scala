package org.usfirst.irs1318.gamesim.engine.action

import org.usfirst.irs1318.gamesim.engine.GameEngine
import org.usfirst.irs1318.gamesim.engine.actors.Field
import org.usfirst.irs1318.gamesim.engine.event.EventLog
import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails

case class ChangePhase(phase: Field.Phase, taskDetails: TaskDetails) extends Action {
  override def run(state: GameEngine.State): GameEngine.State = {
    state
      .mapField(_.mapPhase(_ => phase))
      .mapEventLog(_ + new EventLog.Entry.Builder()
        .putContent("action", "ChangePhase")
        .putContent("phase", phase.toString)
        .putContent("time", state.time.toString)
        .build)
  }
}
