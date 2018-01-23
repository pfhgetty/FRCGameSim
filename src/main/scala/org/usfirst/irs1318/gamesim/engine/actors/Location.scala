package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.actors.Direction.{Down, Left, Right, Up}

case class Location(x: Int, y: Int) {
  def translate(direction: Direction): Location = direction match {
    case Left => copy(x = x - 1)
    case Right => copy(x = x + 1)
    case Up => copy(y = y + 1)
    case Down => copy(y = y - 1)
  }

  override def toString: String = s"($x, $y)"
}
