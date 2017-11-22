package org.usfirst.irs1318.gamesim.engine;

import java.util.Optional;
import java.util.Set;

public class Container {
    public int capacity;
    public Location location;
    public Set<Containable> contained;

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
}
