package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.actors.Field.Contents

case class Field(width: Int,
                 height: Int,
                 phase: Field.Phase,
                 contents: Contents) {
  @inline def mapPhase(fn: Field.Phase => Field.Phase): Field = copy(phase = fn(phase))
  @inline def mapContents(fn: Contents => Contents): Field = copy(contents = fn(contents))
}

object Field {
  type Content = Actor
  type Contents = Map[String, Content]

  sealed abstract class Phase

  object Phase {
    case object Pre extends Phase
    case object Auto extends Phase
    case object Teleop extends Phase
    case object Post extends Phase
  }

  case class Builder(field: Field) {
    def this() = this(Field(0, 0, Phase.Pre, Map.empty))
    @inline def mapField(fn: Field => Field): Builder = copy(field = fn(field))
    def setWidth(width: Int): Builder = mapField(_.copy(width = width))
    def setHeight(height: Int): Builder = mapField(_.copy(height = height))
    def setPhase(phase: Phase): Builder = mapField(_.copy(phase = phase))
    def setContents(contents: Contents): Builder = mapField(_.mapContents(_ => contents))
    def putContent(content: Content): Builder = mapField(_.mapContents(_ + ((content.name, content))))
    def build: Field = field
  }
}
