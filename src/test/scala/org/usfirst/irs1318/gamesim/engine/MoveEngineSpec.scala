package org.usfirst.irs1318.gamesim.engine

import org.usfirst.irs1318.gamesim.UnitSpec
import org.usfirst.irs1318.gamesim.engine.action.Move
import org.usfirst.irs1318.gamesim.engine.actors.Direction._
import org.usfirst.irs1318.gamesim.engine.actors._
import org.usfirst.irs1318.gamesim.engine.event.Event
import org.usfirst.irs1318.gamesim.engine.time.Time

class MoveEngineSpec extends UnitSpec {
  List(Left, Right, Up, Down).foreach { direction =>
    s"Move $direction" should s"move an actor $direction" in {
      val gameEngine = GameEngine()

      val state = new GameEngine.State.Builder()
        .addEvent(Event(Time(0), Move("robot", direction)))
        .addActor(Robot("robot", Location(0, 0), Map.empty))
        .build

      val newState = gameEngine.simulateState(state)

      newState.actors("robot").location shouldBe Location(0, 0).translate(direction)
    }
  }
}
