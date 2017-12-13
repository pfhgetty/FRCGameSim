package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.container.{Containable, Container}

case class FieldSquare(occupant: Container,
                       location: Location,
                       containers: Map[String, Containable]) extends Actor {

}
