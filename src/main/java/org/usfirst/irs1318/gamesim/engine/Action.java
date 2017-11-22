package org.usfirst.irs1318.gamesim.engine;

public abstract class Action {
    protected final Actor actor;
    private final TaskDetails taskDetails;

    public Action(Actor actor, TaskDetails taskDetails) {
        this.actor = actor;
        this.taskDetails = taskDetails;
    }

    public void performAction() {
        // TODO Add listeners
        if (taskDetails.succeeded()) {
            performSuccessAction();
        } else {
            performFailureAction();
        }
    }

    public abstract void performSuccessAction();
    public abstract void performFailureAction();

    public Actor getActor() {
        return actor;
    }

    public TaskDetails getTaskDetails() {
        return taskDetails;
    }
}
