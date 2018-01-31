package org.usfirst.irs1318.gamesim.engine.action

import org.usfirst.irs1318.gamesim.engine.GameEngine
import org.usfirst.irs1318.gamesim.engine.actors._
import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails

case class Move(name: String, direction: Direction, taskDetails: TaskDetails) extends Action {
  override def run(state: GameEngine.State): GameEngine.State = state
    .mapActor(name, _.mapLocation(_.translate(direction)))
}
