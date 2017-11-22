package org.usfirst.irs1318.gamesim.engine;

import java.util.Map;

public final class Field {
    private final int width;
    private final int height;
    private Map<Location, FieldSquare> content;

    public Field(int width, int height, Map<Location, FieldSquare> content) {
        this.width = width;
        this.height = height;
        this.content = content;
    }

    public Location getDestination(Location start, Direction direction) {
        // TODO
        throw new RuntimeException("Not implemented");
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Map<Location, FieldSquare> getContent() {
        return content;
    }

    public void setContent(Map<Location, FieldSquare> content) {
        this.content = content;
    }
}
