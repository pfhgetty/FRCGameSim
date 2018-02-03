package org.usfirst.irs1318.gamesim.engine.event

import org.usfirst.irs1318.gamesim.engine.action.Action
import org.usfirst.irs1318.gamesim.engine.time.Time
import org.usfirst.irs1318.gamesim.engine.time.Time._

case class Event(time: Time, action: Action)

object Event {
  implicit object EventOrdering extends Ordering[Event] {
    override def compare(x: Event, y: Event): Int = TimeOrdering.compare(x.time, y.time)
  }
}
