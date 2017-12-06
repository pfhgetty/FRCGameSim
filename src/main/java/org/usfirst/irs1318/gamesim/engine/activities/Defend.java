package org.usfirst.irs1318.gamesim.engine.activities;

import org.usfirst.irs1318.gamesim.engine.actors.Actor;
import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails;

public final class Defend extends Activity {
    private final Actor defended;

    public Defend(Actor actor, TaskDetails taskDetails, Actor defended) {
        super(actor, taskDetails);
        this.defended = defended;
    }

    /**
     * Have the defended delay by the TaskDetail's duration.
     */
    @Override
    public void performSuccessActivity() {
        // TODO
    }

    /**
     * Noop
     */
    @Override
    public void performFailureActivity() {
        // TODO
    }

    public Actor getDefended() {
        return defended;
    }
}
