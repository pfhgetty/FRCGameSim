package org.usfirst.irs1318.gamesim.engine

import org.usfirst.irs1318.gamesim.engine.GameEngine.State.Phase
import org.usfirst.irs1318.gamesim.engine.actors._
import org.usfirst.irs1318.gamesim.engine.event._
import org.usfirst.irs1318.gamesim.engine.objective.DependencyManager
import org.usfirst.irs1318.gamesim.engine.time.Time
import org.usfirst.irs1318.gamesim.game._

import scala.annotation.tailrec

case class GameEngine() {
  def playMatch(`match`: Match): MatchResult = ???

  @tailrec final def simulateState(state: GameEngine.State): GameEngine.State = {
    simulateNextEvent(state) match {
      case None => state
      case Some(newState) => simulateState(newState)
    }
  }

  def simulateNextEvent(state: GameEngine.State): Option[GameEngine.State] = {
    state.eventQueue.pop().map { case (event, newEventQueue) =>
      simulateEvent(event, state.mapEventQueue(_ => newEventQueue))
    }
  }

  def simulateEvent(event: Event, state: GameEngine.State): GameEngine.State =
    event.action.run(state
      .mapTime(_ => event.time)
      .mapEventLog(_ :+ event))
}

object GameEngine {
  type EventLog = List[Event]

  case class State(time: Time,
                   actors: Actors,
                   phase: Phase,
                   eventQueue: EventQueue,
                   dependencyManager: DependencyManager,
                   eventLog: EventLog) {
    @inline def mapTime(fn: Time => Time): State = copy(time = fn(time))
    @inline def mapActors(fn: Actors => Actors): State = copy(actors = fn(actors))
    @inline def mapPhase(fn: Phase => Phase): State = copy(phase = fn(phase))
    @inline def mapEventQueue(fn: EventQueue => EventQueue): State = copy(eventQueue = fn(eventQueue))
    @inline def mapDependencyManager(fn: DependencyManager => DependencyManager): State = copy(dependencyManager = fn(dependencyManager))
    @inline def mapEventLog(fn: EventLog => EventLog): State = copy(eventLog = fn(eventLog))

    def mapActor(name: String, fn: Actor => Actor): State = mapActors(_.map(name, fn))
    def mapActor(location: Location, fn: Actor => Actor): State = mapActors(_.map(location, fn))
  }

  object State {
    sealed abstract class Phase

    object Phase {
      case object Pre extends Phase
      case object Auto extends Phase
      case object Teleop extends Phase
      case object Post extends Phase
    }

    case class Builder(state: State) {
      def this() = this(State(Time(0), Actors(), Phase.Pre, EventQueue(), DependencyManager(), List.empty))
      @inline def mapState(fn: State => State): Builder = copy(state = fn(state))
      def setTime(time: Time): Builder = mapState(_.mapTime(_ => time))
      def setActors(actors: Actors): Builder = mapState(_.mapActors(_ => actors))
      def setEventQueue(eventQueue: EventQueue): Builder = mapState(_.mapEventQueue(_ => eventQueue))
      def setDependencyManager(dependencyManager: DependencyManager): Builder = mapState(_.mapDependencyManager(_ => dependencyManager))
      def setEventLog(eventLog: EventLog): Builder = mapState(_.mapEventLog(_ => eventLog))
      def addActor(actor: Actor): Builder = mapState(_.mapActors(_.add(actor)))
      def addEvent(event: Event): Builder = mapState(_.mapEventQueue(_ + event))
      def addLogEntry(entry: Event): Builder = mapState(_.mapEventLog(_ :+ entry))
      def build: State = state
    }
  }
}
