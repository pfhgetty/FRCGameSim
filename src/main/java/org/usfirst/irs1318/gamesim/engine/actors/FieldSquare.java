package org.usfirst.irs1318.gamesim.engine.actors;

import org.usfirst.irs1318.gamesim.engine.container.Container;

import java.util.Map;

public final class FieldSquare extends Actor {
    private final Location location;
    private Container occupant;
    private Map<String, Target> targets;

    public FieldSquare(Location location, Container occupant, Map<String, Target> targets, Map<String, Container> containers) {
        super(location, containers);
        this.location = location;
        this.occupant = occupant;
        this.targets = targets;
    }

    public Location getLocation() {
        return location;
    }

    public Container getOccupant() {
        return occupant;
    }

    public void setOccupant(Container occupant) {
        this.occupant = occupant;
    }

    public Map<String, Target> getTargets() {
        return targets;
    }

    public void setTargets(Map<String, Target> targets) {
        this.targets = targets;
    }
}
