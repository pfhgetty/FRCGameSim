package org.usfirst.irs1318.gamesim.engine;

import java.util.Map;
import java.util.Optional;

public abstract class Actor implements Containable {
    protected Location location;
    protected Map<String, Container> containers;

    public Actor(Location location, Map<String, Container> containers) {
        this.location = location;
        this.containers = containers;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Map<String, Container> getContainers() {
        return containers;
    }

    public void setContainers(Map<String, Container> containers) {
        this.containers = containers;
    }

    public Optional<Container> getPayloadContainer(String key) {
        return Optional.ofNullable(containers.get(key));
    }

    public void addPayload(String payloadType, Containable payload) {
        Container container = containers.get(payloadType);
        container.placeContent(payload);
    }
}
