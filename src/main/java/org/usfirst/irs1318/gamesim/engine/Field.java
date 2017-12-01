package org.usfirst.irs1318.gamesim.engine;

import java.util.Map;

public final class Field extends Actor {
    private final int width;
    private final int height;
    private Map<Location, FieldSquare> content;
    private Phase phase;

    public Field(int width, int height, Map<Location, FieldSquare> content, Map<String, Container> containers) {
        super(new Location(0, 0), containers);
        this.width = width;
        this.height = height;
        this.content = content;
        this.phase = Phase.PRE;
    }

    public enum Phase {
        PRE,
        AUTO,
        TELEOP,
        POST
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

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }
}
