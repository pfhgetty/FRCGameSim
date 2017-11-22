package org.usfirst.irs1318.gamesim.engine;

import java.util.Map;
import java.util.Optional;

public class Actor implements Containable {
    private Location location;
    private Map<String, Container> containers;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Optional<Container> getPayloadContainer(String key) {
        return Optional.ofNullable(containers.get(key));
    }

    public void addPayload(String payloadType, Containable payload) {
        Container container = containers.get(payloadType);
        container.placeContent(payload);
    }
}
