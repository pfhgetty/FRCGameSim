package org.usfirst.irs1318.gamesim.interpret

case class ComposedInterpreter[-Action, State](i1: Interpreter[Action, State],
                                               i2: Interpreter[Action, State]) extends Interpreter[Action, State] {
  override def run(action: Action, state: State): State = i2.run(action, i1.run(action, state))
}

