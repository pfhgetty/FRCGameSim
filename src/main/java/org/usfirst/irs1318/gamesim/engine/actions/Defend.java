package org.usfirst.irs1318.gamesim.engine.actions;

import org.usfirst.irs1318.gamesim.engine.Action;
import org.usfirst.irs1318.gamesim.engine.Actor;
import org.usfirst.irs1318.gamesim.engine.TaskDetails;

public final class Defend extends Action {
    private final Actor defended;

    public Defend(Actor actor, TaskDetails taskDetails, Actor defended) {
        super(actor, taskDetails);
        this.defended = defended;
    }

    /**
     * Have the defended delay by the TaskDetail's duration.
     */
    @Override
    public void performSuccessAction() {
        // TODO
    }

    /**
     * Noop
     */
    @Override
    public void performFailureAction() {
        // TODO
    }

    public Actor getDefended() {
        return defended;
    }
}
