package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.container.Containable

trait Actor {
  def location: Location
  def containers: Map[String, Containable]
}
