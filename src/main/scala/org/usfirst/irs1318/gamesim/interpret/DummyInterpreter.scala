package org.usfirst.irs1318.gamesim.interpret

case class DummyInterpreter[Action, State]() extends Interpreter[Action, State] {
  override def run(action: Action, state: State): State = state
}
