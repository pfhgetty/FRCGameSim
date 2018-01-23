package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.container.{Containable, Container}

trait Actor extends Containable {
  def name: String
  def containers: Map[String, Container]
  def location: Location
}
