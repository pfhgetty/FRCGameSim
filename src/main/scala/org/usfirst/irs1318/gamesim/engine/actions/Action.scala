package org.usfirst.irs1318.gamesim.engine.actions

import org.usfirst.irs1318.gamesim.engine.actors.{Actor, Field}
import org.usfirst.irs1318.gamesim.engine.container.Container
import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails

sealed trait Action {
  def actor: Actor
  def taskDetails: TaskDetails
}

object Action {
  case class ChangePhase(phase: Field.Phase, actor: Actor, taskDetails: TaskDetails) extends Action
  case class Move(direction: Direction, actor: Actor, taskDetails: TaskDetails) extends Action
  case class Defend(target: Actor, actor: Actor, taskDetails: TaskDetails) extends Action
  case class Pick(source: Container, failure: Container, actor: Actor, taskDetails: TaskDetails) extends Action
  case class Place(dest: Container, failure: Container, actor: Actor, taskDetails: TaskDetails) extends Action
  case class Shoot(dest: Container, failure: Container, actor: Actor, taskDetails: TaskDetails) extends Action
}
