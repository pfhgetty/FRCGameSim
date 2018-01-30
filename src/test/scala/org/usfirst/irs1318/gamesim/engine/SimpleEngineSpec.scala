package org.usfirst.irs1318.gamesim.engine

import org.usfirst.irs1318.gamesim.UnitSpec
import org.usfirst.irs1318.gamesim.engine.action.ChangePhase
import org.usfirst.irs1318.gamesim.engine.actors.Field
import org.usfirst.irs1318.gamesim.engine.event.Event
import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails

//noinspection ZeroIndexToHead
class SimpleEngineSpec extends UnitSpec {
  "The game engine" should "step through phases and log events" in {
    val gameEngine = new GameEngine()

    val switchToAuto = Event(0, ChangePhase(Field.Phase.Auto, new TaskDetails.Builder().build))
    val switchToTeleop = Event(15, ChangePhase(Field.Phase.Teleop, new TaskDetails.Builder().build))
    val switchToPost = Event(200, ChangePhase(Field.Phase.Post, new TaskDetails.Builder().build))

    val state = new GameEngine.State.Builder()
      .addEvent(switchToAuto)
      .addEvent(switchToTeleop)
      .addEvent(switchToPost)
      .build

    val newState = gameEngine.simulateState(state)

    newState.time shouldEqual 200

    newState.eventLog(0) shouldEqual Event(0, ChangePhase(Field.Phase.Auto, new TaskDetails.Builder().build))
    newState.eventLog(1) shouldEqual Event(15, ChangePhase(Field.Phase.Teleop, new TaskDetails.Builder().build))
    newState.eventLog(2) shouldEqual Event(200, ChangePhase(Field.Phase.Post, new TaskDetails.Builder().build))
  }
}
