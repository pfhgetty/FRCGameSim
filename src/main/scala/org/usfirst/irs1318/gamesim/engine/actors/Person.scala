package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.container.Container

// TODO
case class Person(name: String, location: Location, containers: Map[String, Container]) extends Actor {
}
