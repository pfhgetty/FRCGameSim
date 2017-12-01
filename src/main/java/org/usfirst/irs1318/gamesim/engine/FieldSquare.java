package org.usfirst.irs1318.gamesim.engine;

import java.util.Map;

public final class FieldSquare implements Containable {
    private final Location location;
    private Container occupant;
    private Map<String, Target> targets;
    private Map<String, Container> gamePieces;

    public FieldSquare(Location location, Container occupant, Map<String, Target> targets, Map<String, Container> gamePieces) {
        this.location = location;
        this.occupant = occupant;
        this.targets = targets;
        this.gamePieces = gamePieces;
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

    public Map<String, Container> getGamePieces() {
        return gamePieces;
    }

    public void setGamePieces(Map<String, Container> gamePieces) {
        this.gamePieces = gamePieces;
    }
}
