package org.usfirst.irs1318.gamesim.engine.event

import cats.Monoid

case class EventLog(entries: List[EventLog.Entry]) {
  @inline def mapEntries(fn: List[EventLog.Entry] => List[EventLog.Entry]): EventLog = copy(entries = fn(entries))

  def +(entry: EventLog.Entry): EventLog = mapEntries(_ :+ entry)

  def ++(eventLog: EventLog): EventLog = mapEntries(_ ++ eventLog.entries)
}

object EventLog {
  def empty: EventLog = EventLog(List.empty)

  implicit object EventLogMonoidImplicit extends Monoid[EventLog] {
    override def empty: EventLog = EventLog.empty
    override def combine(x: EventLog, y: EventLog): EventLog = x ++ y
  }

  case class Entry(content: Map[String, String])
}
