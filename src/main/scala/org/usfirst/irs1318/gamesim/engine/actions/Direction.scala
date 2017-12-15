package org.usfirst.irs1318.gamesim.engine.actions

case class Direction(name: String)
object Direction {
  val LEFT = Direction("left")
  val RIGHT = Direction("right")
  val UP = Direction("up")
  val DOWN = Direction("down")
}
