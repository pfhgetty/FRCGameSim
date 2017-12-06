package org.usfirst.irs1318.gamesim.engine.activities;

import org.usfirst.irs1318.gamesim.engine.actors.*;
import org.usfirst.irs1318.gamesim.engine.objective.TaskDetails;

public final class Move extends Activity {
    private final Field field;
    private final Direction direction;

    public Move(Actor actor, TaskDetails taskDetails, Field field, Direction direction) {
        super(actor, taskDetails);
        this.field = field;
        this.direction = direction;
    }

    @Override
    public void performSuccessActivity() {
        Location start = actor.getLocation();
        Location destination = field.getDestination(start, direction);
        if (!destination.equals(start)) {
            actor.setLocation(destination);
        }
    }

    @Override
    public void performFailureActivity() {
        // TODO
    }

    public Field getField() {
        return field;
    }

    public Direction getDirection() {
        return direction;
    }
}
