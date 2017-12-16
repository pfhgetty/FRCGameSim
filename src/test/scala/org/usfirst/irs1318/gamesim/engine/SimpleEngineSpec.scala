package org.usfirst.irs1318.gamesim.engine

import org.scalatest.{FlatSpec, Matchers}
import org.usfirst.irs1318.gamesim.engine.actions.Action
import org.usfirst.irs1318.gamesim.engine.actors.Field
import org.usfirst.irs1318.gamesim.engine.event.{Event, EventLog}
import org.usfirst.irs1318.gamesim.engine.interpret.DefaultGameEngineInterpreter
import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails

//noinspection ZeroIndexToHead
class SimpleEngineSpec extends FlatSpec with Matchers {
  "The game engine" should "step through phases and log events" in {
    val gameEngine = GameEngine(DefaultGameEngineInterpreter.instance)

    val switchToAuto = Event(0, Action.ChangePhase(Field.Phase.AUTO, new TaskDetails.Builder("switchToAuto").build))
    val switchToTeleop = Event(15, Action.ChangePhase(Field.Phase.TELEOP, new TaskDetails.Builder("switchToTeleop").build))
    val switchToPost = Event(200, Action.ChangePhase(Field.Phase.POST, new TaskDetails.Builder("switchToPost").build))

    val state = new GameEngine.State.Builder()
      .addEvent(switchToAuto)
      .addEvent(switchToTeleop)
      .addEvent(switchToPost)
      .build

    val newState = gameEngine.simulateState(state)

    newState.time should be (200)

    newState.eventLog.entries(0) should be
      new EventLog.Entry.Builder()
        .putContent("action", "ChangePhase")
        .putContent("phase", "auto")
        .putContent("time", "0")
        .build

    newState.eventLog.entries(1) should be
      new EventLog.Entry.Builder()
        .putContent("action", "ChangePhase")
        .putContent("phase", "teleop")
        .putContent("time", "15")
        .build

    newState.eventLog.entries(2) should be
      new EventLog.Entry.Builder()
        .putContent("action", "ChangePhase")
        .putContent("phase", "post")
        .putContent("time", "200")
        .build
  }
}
