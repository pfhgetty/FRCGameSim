package org.usfirst.irs1318.gamesim.engine.event

case class EventLog(entries: List[EventLog.Entry]) {
  @inline def mapEntries(fn: List[EventLog.Entry] => List[EventLog.Entry]): EventLog = copy(entries = fn(entries))

  def +(entry: EventLog.Entry): EventLog = mapEntries(_ :+ entry)

  def ++(eventLog: EventLog): EventLog = mapEntries(_ ++ eventLog.entries)
}

object EventLog {
  def empty: EventLog = EventLog(List.empty)

  case class Entry(content: Map[String, String])
}
