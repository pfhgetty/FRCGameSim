package org.usfirst.irs1318.gamesim.engine;

import java.util.Optional;
import java.util.Set;

public final class Container {
    private final int capacity;
    private Location location;
    private Set<Containable> contained;

    public Container(int capacity, Location location, Set<Containable> contained) {
        this.capacity = capacity;
        this.location = location;
        this.contained = contained;
    }

    /**
     * Remove a containers from the container.
     */
    public Optional<Containable> retrieveContents() {
        // TODO If container is empty
        throw new RuntimeException("TODO");
    }

    public void placeContent(Containable containable) {
        // TODO Event
    }

    public int getCapacity() {
        return capacity;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Set<Containable> getContained() {
        return contained;
    }

    public void setContained(Set<Containable> contained) {
        this.contained = contained;
    }
}
