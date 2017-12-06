package org.usfirst.irs1318.gamesim.engine.event;

import org.usfirst.irs1318.gamesim.engine.activities.Activity;

import java.time.Instant;

// TODO
public class Event {
    private final Instant time;
    private final Activity activity;

    public Event(Instant time, Activity activity) {
        this.time = time;
        this.activity = activity;
    }

    public Instant getTime() {
        return time;
    }

    public Activity getActivity() {
        return activity;
    }
}
