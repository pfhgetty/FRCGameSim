package org.usfirst.irs1318.gamesim.engine.actions;

import org.usfirst.irs1318.gamesim.engine.*;

public final class Move extends Action {
    private final Field field;
    private final Direction direction;

    public Move(Actor actor, TaskDetails taskDetails, Field field, Direction direction) {
        super(actor, taskDetails);
        this.field = field;
        this.direction = direction;
    }

    @Override
    public void performSuccessAction() {
        Location start = actor.getLocation();
        Location destination = field.getDestination(start, direction);
        if (!destination.equals(start)) {
            actor.setLocation(destination);
        }
    }

    @Override
    public void performFailureAction() {
        // TODO
    }

    public Field getField() {
        return field;
    }

    public Direction getDirection() {
        return direction;
    }
}
