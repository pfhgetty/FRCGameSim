package org.usfirst.irs1318.gamesim.engine.objective

case class TaskDetails(taskDuration: Long,
                       reactionDuration: Long,
                       reliability: Float,
                       task: Task)

object TaskDetails {
  case class Builder(taskDetails: TaskDetails) {
    def this() = this(TaskDetails(0, 0, 1.0f, new Task.Builder().build))
    @inline def mapTaskDetails(fn: TaskDetails => TaskDetails): Builder = copy(taskDetails = fn(taskDetails))
    def setTaskDuration(taskDuration: Long): Builder = mapTaskDetails(_.copy(taskDuration = taskDuration))
    def setReactionDuration(reactionDuration: Long): Builder = mapTaskDetails(_.copy(reactionDuration = reactionDuration))
    def setReliability(reliability: Float): Builder = mapTaskDetails(_.copy(reliability = reliability))
    def setTask(task: Task): Builder = mapTaskDetails(_.copy(task = task))
    def build: TaskDetails = taskDetails
  }
}
