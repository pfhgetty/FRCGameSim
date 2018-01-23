package org.usfirst.irs1318.gamesim.engine.action

import org.usfirst.irs1318.gamesim.engine.GameEngine
import org.usfirst.irs1318.gamesim.engine.actors.Actor
import org.usfirst.irs1318.gamesim.engine.container.Container
import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails

case class Pick(source: Container, failure: Container, actor: Actor, taskDetails: TaskDetails) extends Action {
  override def run(state: GameEngine.State): GameEngine.State = ???
}
