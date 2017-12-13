package org.usfirst.irs1318.gamesim.engine.event

import java.time.Instant

case class EventLog(entries: List[EventLog.Entry]) {

}

object EventLog {
  case class Entry(instant: Instant, content: Map[String, String])
}
