package org.usfirst.irs1318.gamesim.engine.event

import java.time.Instant

import org.usfirst.irs1318.gamesim.engine.actions.Action

case class Event(time: Instant, action: Action) {

}
