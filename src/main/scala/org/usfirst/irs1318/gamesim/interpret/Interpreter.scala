package org.usfirst.irs1318.gamesim.interpret

trait Interpreter[-Action, State] {
  def run(action: Action, state: State): State
}

object Interpreter {
}
