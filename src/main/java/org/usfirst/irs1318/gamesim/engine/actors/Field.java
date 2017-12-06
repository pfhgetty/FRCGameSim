package org.usfirst.irs1318.gamesim.engine.actors;

import org.usfirst.irs1318.gamesim.engine.activities.Direction;
import org.usfirst.irs1318.gamesim.engine.container.Container;

import java.util.*;

public final class Field extends Actor {
    private final int width;
    private final int height;
    private Phase phase;

    /**
     * Containers that can be accessed by location rather than String token.
     */
    private Map<Location, FieldSquare> fieldSquares;

    private Field(int width, int height, Phase phase, Map<Location, FieldSquare> fieldSquares, Location location, Map<String, Container> containers) {
        super(location, containers);
        this.width = width;
        this.height = height;
        this.fieldSquares = fieldSquares;
        this.phase = phase;
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

    public Map<Location, FieldSquare> getFieldSquares() {
        return fieldSquares;
    }

    public void setFieldSquares(Map<Location, FieldSquare> fieldSquares) {
        this.fieldSquares = fieldSquares;
    }

    public Phase getPhase() {
        return phase;
    }

    public void setPhase(Phase phase) {
        this.phase = phase;
    }

    public static class Builder extends Actor.Builder {
        private int width;
        private int height;
        private Phase phase = Phase.PRE;
        private Map<Location, FieldSquare> fieldSquares;
        private Location location = new Location(0, 0);
        private Map<String, Container> containers = new HashMap<>();

        public Builder setWidth(int width) {
            this.width = width;
            return this;
        }

        public Builder setHeight(int height) {
            this.height = height;
            return this;
        }

        public Builder setPhase(Phase phase) {
            this.phase = phase;
            return this;
        }

        public Builder setFieldSquares(Map<Location, FieldSquare> fieldSquares) {
            this.fieldSquares = fieldSquares;
            return this;
        }

        public Builder putFieldSquare(Location location, FieldSquare fieldSquare) {
            this.fieldSquares.put(location, fieldSquare);
            return this;
        }

        public Builder setLocation(Location location) {
            this.location = location;
            return this;
        }

        public Builder setContainers(Map<String, Container> containers) {
            this.containers = containers;
            return this;
        }

        public Builder putContainer(String string, Container container) {
            this.containers.put(string, container);
            return this;
        }

        @Override
        public Actor build() {
            return new Field(width, height, phase, fieldSquares, location, containers);
        }
    }
}
