package org.usfirst.irs1318.gamesim.engine.event

import scala.collection.immutable.SortedSet

case class EventQueue(private val queue: SortedSet[Event] = SortedSet[Event]()) {
  @inline def mapQueue(fn: SortedSet[Event] => SortedSet[Event]): EventQueue = copy(queue = fn(queue))

  def +(event: Event): EventQueue = mapQueue(_ + event)

  def -(event: Event): EventQueue = mapQueue(_ - event)

  def peek(): Option[Event] = {
    if (queue.isEmpty) None else Some(queue.firstKey)
  }

  def pop(): Option[(Event, EventQueue)] = {
    if (queue.isEmpty) {
      None
    } else {
      val first = queue.firstKey
      Some((first, this - first))
    }
  }
}
