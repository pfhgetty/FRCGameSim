package org.usfirst.irs1318.gamesim.engine.actors

import org.usfirst.irs1318.gamesim.engine.container.Containable

// TODO
case class Robot(location: Location, containers: Map[String, Containable]) extends Actor
