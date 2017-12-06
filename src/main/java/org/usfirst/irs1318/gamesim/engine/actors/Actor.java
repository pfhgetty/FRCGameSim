package org.usfirst.irs1318.gamesim.engine.actors;

import org.usfirst.irs1318.gamesim.engine.container.*;

import java.util.*;

public abstract class Actor implements Containable {
    private Location location;
    private final Map<String, Container> containers;

    protected Actor(Location location, Map<String, Container> containers) {
        this.location = location;
        this.containers = Collections.unmodifiableMap(containers);
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

    public Optional<Container> getPayloadContainer(String key) {
        return Optional.ofNullable(containers.get(key));
    }

    public void addPayload(String payloadType, Containable payload) {
        Container container = containers.get(payloadType);
        container.placeContent(payload);
    }

    public static abstract class Builder {
        protected Location location;
        protected Map<String, Container> containers = new HashMap<>();

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

        public abstract Actor build();
    }
}
