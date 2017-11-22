package org.usfirst.irs1318.gamesim.engine;

import java.time.Duration;

public final class TaskDetails {
    public Duration taskDuration;
    public Duration reactionDuration;

    /**
     * A number between 0 and 1.
     */
    public float reliability;

    public Task task;

    /**
     * @return true if a rng is <= reliability.
     */
    public boolean succeeded() {
        // TODO
        return true;
    }
}
