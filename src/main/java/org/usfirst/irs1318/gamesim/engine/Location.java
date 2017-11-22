package org.usfirst.irs1318.gamesim.engine;

import java.util.Objects;

public final class Location {
    private int x;
    private int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Returns true if the location is within proximity field squares of the location.
     *
     * @param proximity A positive integer to test.
     */
    public boolean isClose(int proximity, Location location) {
        // TODO
        return true;
    }

    /**
     * Returns the Manhattan distance between two locations.
     */
    public int getDistance(Location location) {
        return x - location.x + y - location.y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x &&
                y == location.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
