package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.container.Containable

trait Actor extends Containable {
  def name: String
}
