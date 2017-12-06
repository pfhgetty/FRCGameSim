package org.usfirst.irs1318.gamesim.engine.activities;

import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails;
import org.usfirst.irs1318.gamesim.engine.actors.Actor;

public abstract class Activity {
    protected final Actor actor;
    private final TaskDetails taskDetails;

    public Activity(Actor actor, TaskDetails taskDetails) {
        this.actor = actor;
        this.taskDetails = taskDetails;
    }

    public void performActivity() {
        // TODO Add listeners
        if (taskDetails.succeeded()) {
            performSuccessActivity();
        } else {
            performFailureActivity();
        }
    }

    public abstract void performSuccessActivity();
    public abstract void performFailureActivity();

    public Actor getActor() {
        return actor;
    }

    public TaskDetails getTaskDetails() {
        return taskDetails;
    }
}
