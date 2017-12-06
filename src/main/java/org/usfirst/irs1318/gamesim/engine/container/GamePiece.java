package org.usfirst.irs1318.gamesim.engine.container;

import org.usfirst.irs1318.gamesim.engine.actors.Location;

public abstract class GamePiece implements Containable {
    protected Location location;

    public GamePiece(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
