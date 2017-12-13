package org.usfirst.irs1318.gamesim.engine.objective

import java.time.Duration

case class TaskDetails(taskDuration: Duration,
                       reactionDuration: Duration,
                       reliability: Float,
                       task: Task) {
  def testSuccess(): Boolean = ???
}
