package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.container.Containable

case class Field(width: Int,
                 height: Int,
                 phase: Field.Phase,
                 contents: Map[Location, Containable]) {
  @inline def mapContents(fn: Map[Location, Containable] => Map[Location, Containable]): Field = copy(contents = fn(contents))
}

object Field {
  case class Phase(name: String)
  object Phase {
    val PRE = Phase("pre")
    val AUTO = Phase("auto")
    val TELEOP = Phase("teleop")
    val POST = Phase("post")
  }

  case class Builder(field: Field) {
    def this() = this(Field(0, 0, Phase.PRE, Map.empty))
    @inline def mapField(fn: Field => Field): Builder = copy(field = fn(field))
    def setWidth(width: Int): Builder = mapField(_.copy(width = width))
    def setHeight(height: Int): Builder = mapField(_.copy(height = height))
    def setPhase(phase: Phase): Builder = mapField(_.copy(phase = phase))
    def setContents(contents: Map[Location, Containable]): Builder = mapField(_.mapContents(_ => contents))
    def putContent(location: Location, containable: Containable): Builder = mapField(_.mapContents(_ + ((location, containable))))
    def build: Field = field
  }
}
