package org.usfirst.irs1318.gamesim.engine.actions;

import org.usfirst.irs1318.gamesim.engine.Action;
import org.usfirst.irs1318.gamesim.engine.Direction;
import org.usfirst.irs1318.gamesim.engine.Field;
import org.usfirst.irs1318.gamesim.engine.Location;

public class Move extends Action {
    public Field field;
    public Direction direction;

    @Override
    public void performSuccessAction() {
        // TODO log
        Location start = actor.getLocation();
        Location destination = field.getDestination(start, direction);
        if (!destination.equals(start)) {
            actor.setLocation(destination);

        } else {

        }
    }

    @Override
    public void performFailureAction() {
        // TODO
    }
}
