package org.usfirst.irs1318.gamesim.engine

import org.usfirst.irs1318.gamesim.engine.actors._

case class Actors(private val locations: Map[Location, String] = Map.empty,
                  private val actors: Map[String, Actor] = Map.empty) {
  def add(actor: Actor): Actors = copy(
    locations = locations + ((actor.location, actor.name)),
    actors = actors + ((actor.name, actor))
  )

  def map(name: String, fn: Actor => Actor): Actors = {
    val actor = this(name)
    val newActor = fn(actor)
    copy(
      locations = locations - actor.location + ((newActor.location, newActor.name)),
      actors = actors - actor.name + ((newActor.name, newActor))
    )
  }

  def map(location: Location, fn: Actor => Actor): Actors = map(locations(location), fn)

  def apply(name: String): Actor = actors(name)
  def apply(location: Location): Actor = actors(locations(location))
}
