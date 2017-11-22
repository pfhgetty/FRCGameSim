package org.usfirst.irs1318.gamesim.engine;

import java.util.Map;

public class Field {
    public int width;
    public int height;
    public Map<Location, FieldSquare> content;

    public Location getDestination(Location start, Direction direction) {
        // TODO
        throw new RuntimeException("Not implemented");
    }
}
