package org.usfirst.irs1318.gamesim.engine.interpret

import org.usfirst.irs1318.gamesim.engine.GameEngine
import org.usfirst.irs1318.gamesim.engine.actions.Action
import org.usfirst.irs1318.gamesim.engine.actions.Action._
import org.usfirst.irs1318.gamesim.engine.event.EventLog

case class LogGameEngineInterpreter() extends GameEngine.Interpreter {
  override def run(action: Action, state: GameEngine.State): GameEngine.State = action match {
    case ChangePhase(phase, taskDetails) =>
      val entry = new EventLog.Entry.Builder()
        .putContent("action", "ChangePhase")
        .putContent("phase", phase.name)
        .putContent("time", state.time.toString)
      state.mapEventLog(log => log + entry.build)
    case Move(direction, actor, taskDetails) => ???
    case Defend(target, actor, taskDetails) => ???
    case Pick(source, failure, actor, taskDetails) => ???
    case Place(dest, failure, actor, taskDetails) => ???
    case Shoot(dest, failure, actor, taskDetails) => ???
  }
}
