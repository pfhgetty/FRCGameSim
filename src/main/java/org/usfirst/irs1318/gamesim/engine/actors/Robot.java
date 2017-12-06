package org.usfirst.irs1318.gamesim.engine.actors;

import org.usfirst.irs1318.gamesim.engine.container.Container;

import java.util.Map;

public final class Robot extends Actor {
    public Robot(Location location, Map<String, Container> containers) {
        super(location, containers);
    }
}
