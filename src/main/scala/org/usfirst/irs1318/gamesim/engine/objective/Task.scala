package org.usfirst.irs1318.gamesim.engine.objective

import org.usfirst.irs1318.gamesim.engine.actions.Action

case class Task(name: String, actions: Set[Action], dependencies: Set[Dependency]) {
  @inline def mapActions(fn: Set[Action] => Set[Action]): Task = copy(actions = fn(actions))
  @inline def mapDependencies(fn: Set[Dependency] => Set[Dependency]): Task = copy(dependencies = fn(dependencies))
}

object Task {
  case class Builder(task: Task) {
    def this(name: String) = this(Task(name, Set.empty, Set.empty))
    @inline def mapTask(fn: Task => Task): Builder = copy(task = fn(task))
    def setActions(actions: Set[Action]): Builder = mapTask(_.mapActions(_ => actions))
    def setDependencies(dependencies: Set[Dependency]): Builder = mapTask(_.mapDependencies(_ => dependencies))
    def addAction(action: Action): Builder = mapTask(_.mapActions(_ + action))
    def addDependency(dependency: Dependency): Builder = mapTask(_.mapDependencies(_ + dependency))
    def build: Task = task
  }
}
