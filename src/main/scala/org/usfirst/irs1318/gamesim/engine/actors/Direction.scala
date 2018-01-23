package org.usfirst.irs1318.gamesim.engine.actors

sealed abstract case class Direction(string: String) {
  override def toString: String = string
}

object Direction {
  object Left extends Direction("left")
  object Right extends Direction("right")
  object Up extends Direction("up")
  object Down extends Direction("down")
}
