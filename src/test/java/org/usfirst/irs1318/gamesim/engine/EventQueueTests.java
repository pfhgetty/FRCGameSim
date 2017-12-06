package org.usfirst.irs1318.gamesim.engine;

import org.junit.Test;
import org.usfirst.irs1318.gamesim.engine.event.*;

import java.time.Instant;

import static org.junit.Assert.assertEquals;

public class EventQueueTests {
    @Test
    public void testEventComparator() {
        EventQueue eventQueue = new EventQueue();
        Event e1 = new Event(Instant.ofEpochMilli(10), null);
        Event e2 = new Event(Instant.ofEpochMilli(10000), null);
        Event e3 = new Event(Instant.ofEpochMilli(10000000), null);
        eventQueue.addEvent(e3);
        eventQueue.addEvent(e1);
        eventQueue.addEvent(e2);
        assertEquals(eventQueue.getNext(), e1);
        assertEquals(eventQueue.getNext(), e2);
        assertEquals(eventQueue.getNext(), e3);
    }
}
