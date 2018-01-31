package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.container.Container

case class Robot(name: String, location: Location, containers: Map[String, Container]) extends Actor {
  override def mapLocation(fn: Location => Location): Actor = copy(location = fn(location))
}
