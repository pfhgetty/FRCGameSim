package org.usfirst.irs1318.gamesim.engine.time

case class Time(long: Long)

object Time {
  implicit object TimeOrdering extends Ordering[Time] {
    override def compare(x: Time, y: Time): Int = x.long compareTo y.long
  }
}
