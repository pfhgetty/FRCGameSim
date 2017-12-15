package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.container.Containable

case class Field(width: Int,
                 height: Int,
                 phase: Field.Phase,
                 location: Location,
                 containers: Map[String, Containable]) extends Actor

object Field {
  case class Phase(name: String)
  object Phase {
    val PRE = Phase("pre")
    val AUTO = Phase("auto")
    val TELEOP = Phase("teleop")
    val POST = Phase("post")
  }
}
