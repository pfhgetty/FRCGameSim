package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.container.Container

trait PhysicalActor extends Actor {
  def containers: Map[String, Container]
  def location: Location
}
