package org.usfirst.irs1318.gamesim.engine.action

import org.usfirst.irs1318.gamesim.engine.GameEngine
import org.usfirst.irs1318.gamesim.engine.container.Container

case class Place(name: String, dest: Container) extends Action {
  override def run(state: GameEngine.State): GameEngine.State = ???
}
