package org.usfirst.irs1318.gamesim.engine.actors;

import org.usfirst.irs1318.gamesim.engine.container.Container;

import java.util.Map;

public final class HumanPlayer extends Actor {
    public HumanPlayer(Location location, Map<String, Container> containers) {
        super(location, containers);
    }
}
