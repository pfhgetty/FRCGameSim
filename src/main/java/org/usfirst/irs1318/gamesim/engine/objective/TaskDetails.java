package org.usfirst.irs1318.gamesim.engine.objective;

import java.time.Duration;

public final class TaskDetails {
    private final Duration taskDuration;
    private final Duration reactionDuration;

    /**
     * A number between 0 and 1.
     */
    private final float reliability;

    private final Task task;

    public TaskDetails(Duration taskDuration, Duration reactionDuration, float reliability, Task task) {
        this.taskDuration = taskDuration;
        this.reactionDuration = reactionDuration;
        this.reliability = reliability;
        this.task = task;
    }

    /**
     * @return true if a rng is <= reliability.
     */
    public boolean succeeded() {
        // TODO
        return true;
    }

    public Duration getTaskDuration() {
        return taskDuration;
    }

    public Duration getReactionDuration() {
        return reactionDuration;
    }

    public float getReliability() {
        return reliability;
    }

    public Task getTask() {
        return task;
    }
}
