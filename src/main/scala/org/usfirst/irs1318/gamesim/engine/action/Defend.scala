package org.usfirst.irs1318.gamesim.engine.action

import org.usfirst.irs1318.gamesim.engine.GameEngine
import org.usfirst.irs1318.gamesim.engine.actors._

case class Defend(location: Location) extends Action {
  override def run(state: GameEngine.State): GameEngine.State = ???
}
