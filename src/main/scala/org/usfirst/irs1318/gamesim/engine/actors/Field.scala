package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.container.Containable

case class Field(width: Int,
                 height: Int,
                 phase: Field.Phase,
                 location: Location,
                 containers: Map[String, Containable]) extends Actor

object Field {
  class Phase
  object Phase extends Enumeration {
    val PRE, AUTO, TELEOP, POST = Value
  }
}
