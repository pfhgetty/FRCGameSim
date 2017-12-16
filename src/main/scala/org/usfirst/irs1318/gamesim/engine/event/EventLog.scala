package org.usfirst.irs1318.gamesim.engine.event

case class EventLog(entries: List[EventLog.Entry]) {
  @inline def mapEntries(fn: List[EventLog.Entry] => List[EventLog.Entry]): EventLog = copy(entries = fn(entries))

  def +(entry: EventLog.Entry): EventLog = mapEntries(_ :+ entry)

  def ++(eventLog: EventLog): EventLog = mapEntries(_ ++ eventLog.entries)
}

object EventLog {
  def empty: EventLog = EventLog(List.empty)

  case class Entry(content: Map[String, String]) {
    @inline def mapContent(fn: Map[String, String] => Map[String, String]): Entry = copy(content = fn(content))
  }

  object Entry {
    case class Builder(entry: Entry) {
      def this() = this(Entry(Map.empty))
      @inline def mapEntry(fn: Entry => Entry): Builder = copy(entry = fn(entry))
      def setContent(content: Map[String, String]): Builder = mapEntry(_.mapContent(_ => content))
      def putContent(name: String, value: String): Builder = mapEntry(_.mapContent(_ + ((name, value))))
      def build: Entry = entry
    }
  }
}
