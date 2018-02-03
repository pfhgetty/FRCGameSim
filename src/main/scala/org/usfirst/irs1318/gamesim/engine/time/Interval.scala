package org.usfirst.irs1318.gamesim.engine.time

import org.usfirst.irs1318.gamesim.engine.time.Time.TimeOrdering

case class Interval(start: Time, end: Time) {
  def contains(time: Time): Boolean = TimeOrdering.gt(time, start) && TimeOrdering.lt(time, end)
}
