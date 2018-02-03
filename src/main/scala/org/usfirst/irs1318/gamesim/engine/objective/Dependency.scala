package org.usfirst.irs1318.gamesim.engine.objective

import org.usfirst.irs1318.gamesim.engine.event.Event

trait Dependency {
  def test(event: Event): Boolean
}
