package org.usfirst.irs1318.gamesim.engine

import org.usfirst.irs1318.gamesim.UnitSpec
import org.usfirst.irs1318.gamesim.engine.action.ChangePhase
import org.usfirst.irs1318.gamesim.engine.actors.Field
import org.usfirst.irs1318.gamesim.engine.event.{Event, EventLog}
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

    newState.eventLog.entries(0) shouldEqual
      new EventLog.Entry.Builder()
        .putContent("action", "ChangePhase")
        .putContent("phase", "auto")
        .putContent("time", "0")
        .build

    newState.eventLog.entries(1) shouldEqual
      new EventLog.Entry.Builder()
        .putContent("action", "ChangePhase")
        .putContent("phase", "teleop")
        .putContent("time", "15")
        .build

    newState.eventLog.entries(2) shouldEqual
      new EventLog.Entry.Builder()
        .putContent("action", "ChangePhase")
        .putContent("phase", "post")
        .putContent("time", "200")
        .build
  }
}
