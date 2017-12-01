package org.usfirst.irs1318.gamesim.engine.actions;

import org.usfirst.irs1318.gamesim.engine.Action;
import org.usfirst.irs1318.gamesim.engine.Field;
import org.usfirst.irs1318.gamesim.engine.TaskDetails;

public final class ChangePhase extends Action {
    private final Field.Phase phase;

    public ChangePhase(Field actor, TaskDetails taskDetails, Field.Phase phase) {
        super(actor, taskDetails);
        this.phase = phase;
    }

    @Override
    public void performSuccessAction() {
        ((Field) actor).setPhase(phase);
        // TODO
    }

    @Override
    public void performFailureAction() {
        // TODO
    }

    public Field.Phase getPhase() {
        return phase;
    }
}
