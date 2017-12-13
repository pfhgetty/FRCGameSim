package org.usfirst.irs1318.gamesim.engine.actions

sealed class Direction

object Direction {
  case object Up extends Direction
  case object Down extends Direction
  case object Left extends Direction
  case object Right extends Direction
}
