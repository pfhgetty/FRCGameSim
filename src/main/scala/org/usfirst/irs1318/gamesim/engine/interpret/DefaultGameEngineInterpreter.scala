package org.usfirst.irs1318.gamesim.engine.interpret

import org.usfirst.irs1318.gamesim.engine.GameEngine
import org.usfirst.irs1318.gamesim.interpret.ComposedInterpreter

object DefaultGameEngineInterpreter {
  implicit def instance: GameEngine.Interpreter = ComposedInterpreter(
    ActionGameEngineInterpreter(),
    LogGameEngineInterpreter()
  )
}
