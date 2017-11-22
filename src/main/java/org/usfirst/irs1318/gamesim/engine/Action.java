package org.usfirst.irs1318.gamesim.engine;

public abstract class Action {
    public Actor actor;
    private TaskDetails details;

    public void performAction() {
        // TODO Add listeners
        if (details.succeeded()) {
            performSuccessAction();
        } else {
            performFailureAction();
        }
    }

    public abstract void performSuccessAction();
    public abstract void performFailureAction();
}
