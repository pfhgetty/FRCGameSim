package org.usfirst.irs1318.gamesim.engine.objective

import org.usfirst.irs1318.gamesim.engine.actions.Action

case class Task(name: String, actions: Set[Action], dependencies: Set[Dependency])
