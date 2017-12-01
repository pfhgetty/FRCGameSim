package org.usfirst.irs1318.gamesim.engine;

import java.time.Instant;

// TODO
public class Event {
    private final Instant time;
    private final Action action;

    public Event(Instant time, Action action) {
        this.time = time;
        this.action = action;
    }

    public Instant getTime() {
        return time;
    }

    public Action getAction() {
        return action;
    }
}
