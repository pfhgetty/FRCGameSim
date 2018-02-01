package org.usfirst.irs1318.gamesim.engine

import org.usfirst.irs1318.gamesim.UnitSpec
import org.usfirst.irs1318.gamesim.engine.GameEngine.State.Phase._
import org.usfirst.irs1318.gamesim.engine.action.ChangePhase
import org.usfirst.irs1318.gamesim.engine.event.Event

//noinspection ZeroIndexToHead
class ChangePhaseEngineSpec extends UnitSpec {
  "The game engine" should "step through phases and log events" in {
    val gameEngine = GameEngine()

    val switchToAuto = Event(0, ChangePhase(Auto))
    val switchToTeleop = Event(15, ChangePhase(Teleop))
    val switchToPost = Event(200, ChangePhase(Post))

    val state = new GameEngine.State.Builder()
      .addEvent(switchToAuto)
      .addEvent(switchToTeleop)
      .addEvent(switchToPost)
      .build

    val newState = gameEngine.simulateState(state)

    newState.time shouldEqual 200

    newState.eventLog(0) shouldEqual Event(0, ChangePhase(Auto))
    newState.eventLog(1) shouldEqual Event(15, ChangePhase(Teleop))
    newState.eventLog(2) shouldEqual Event(200, ChangePhase(Post))
  }
}
