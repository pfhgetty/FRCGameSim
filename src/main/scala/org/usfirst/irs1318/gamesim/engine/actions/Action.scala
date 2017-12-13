package org.usfirst.irs1318.gamesim.engine.actions

import org.usfirst.irs1318.gamesim.engine.EngineState
import org.usfirst.irs1318.gamesim.engine.actors.{Actor, Field}
import org.usfirst.irs1318.gamesim.engine.container.Container
import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails

sealed trait Action {
  def actor: Actor
  def taskDetails: TaskDetails

  def performAction(engineState: EngineState): EngineState = {
    if (taskDetails.testSuccess()) {
      performSuccessAction(engineState)
    } else {
      performFailureAction(engineState)
    }
  }

  def performSuccessAction(engineState: EngineState): EngineState
  def performFailureAction(engineState: EngineState): EngineState
}

object Action {
  case class ChangePhase(phase: Field.Phase, actor: Actor, taskDetails: TaskDetails) extends Action {
    override def performSuccessAction(engineState: EngineState): EngineState = ???
    override def performFailureAction(engineState: EngineState): EngineState = ???
  }

  case class Move(direction: Direction, actor: Actor, taskDetails: TaskDetails) extends Action {
    override def performSuccessAction(engineState: EngineState): EngineState = ???
    override def performFailureAction(engineState: EngineState): EngineState = ???
  }

  case class Pick(source: Container, failure: Container, actor: Actor, taskDetails: TaskDetails) extends Action {
    override def performSuccessAction(engineState: EngineState): EngineState = ???
    override def performFailureAction(engineState: EngineState): EngineState = ???
  }

  case class Place(dest: Container, failure: Container, actor: Actor, taskDetails: TaskDetails) extends Action {
    override def performSuccessAction(engineState: EngineState): EngineState = ???
    override def performFailureAction(engineState: EngineState): EngineState = ???
  }

  case class Shoot(dest: Container, failure: Container, actor: Actor, taskDetails: TaskDetails) extends Action {
    override def performSuccessAction(engineState: EngineState): EngineState = ???
    override def performFailureAction(engineState: EngineState): EngineState = ???
  }
}
