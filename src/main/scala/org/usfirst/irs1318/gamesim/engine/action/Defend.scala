package org.usfirst.irs1318.gamesim.engine.action

import org.usfirst.irs1318.gamesim.engine.GameEngine
import org.usfirst.irs1318.gamesim.engine.actors.Actor

case class Defend(target: Actor, actor: Actor) extends Action {
  override def run(state: GameEngine.State): GameEngine.State = ???
}
