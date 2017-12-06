package org.usfirst.irs1318.gamesim.engine.activities;

import org.usfirst.irs1318.gamesim.engine.actors.Field;
import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails;

public final class ChangePhase extends Activity {
    private final Field.Phase phase;

    public ChangePhase(Field actor, TaskDetails taskDetails, Field.Phase phase) {
        super(actor, taskDetails);
        this.phase = phase;
    }

    @Override
    public void performSuccessActivity() {
        ((Field) actor).setPhase(phase);
        // TODO
    }

    @Override
    public void performFailureActivity() {
        // TODO
    }

    public Field.Phase getPhase() {
        return phase;
    }
}
