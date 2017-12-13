package org.usfirst.irs1318.gamesim.engine

import java.time.Instant

import org.usfirst.irs1318.gamesim.engine.actors.Field
import org.usfirst.irs1318.gamesim.engine.event.{EventLog, EventQueue}
import org.usfirst.irs1318.gamesim.engine.objective.DependencyManager

case class EngineState(time: Instant,
                       field: Field,
                       eventQueue: EventQueue,
                       dependencyManager: DependencyManager,
                       eventLog: EventLog)
