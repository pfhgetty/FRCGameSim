package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.container.Containable

case class Field(width: Int,
                 height: Int,
                 phase: Field.Phase,
                 location: Location,
                 containers: Map[String, Containable]) extends Actor {

}

object Field {
  sealed class Phase
  object Phase {
    case object Pre extends Phase
    case object Auto extends Phase
    case object Teleop extends Phase
    case object Post extends Phase
  }
}
