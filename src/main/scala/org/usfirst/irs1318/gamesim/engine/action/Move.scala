package org.usfirst.irs1318.gamesim.engine.action

import org.usfirst.irs1318.gamesim.engine.GameEngine
import org.usfirst.irs1318.gamesim.engine.actors._

case class Move(name: String, direction: Direction) extends Action {
  override def run(state: GameEngine.State): GameEngine.State = state
    .mapActor(name, _.mapLocation(_.translate(direction)))
}
