package org.usfirst.irs1318.gamesim.engine.container;

import com.brianegan.bansa.Store;

import java.util.*;

public final class Container {
    private final int capacity;
    private Store<Set<Containable>> contained;

    public Container(int capacity, Store<Set<Containable>> contained) {
        this.capacity = capacity;
        this.contained = contained;
    }

    /**
     * Remove a containable from the container.
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

    public Store<Set<Containable>> getContained() {
        return contained;
    }

    public void setContained(Store<Set<Containable>> contained) {
        this.contained = contained;
    }
}
