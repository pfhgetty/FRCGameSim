package org.usfirst.irs1318.gamesim.engine.event;

import java.util.Comparator;
import java.util.PriorityQueue;

public class EventQueue {
    private final PriorityQueue<Event> queue = new PriorityQueue<>(Comparator.comparing(Event::getTime));

    public void addEvent(Event event) {
        queue.offer(event);
    }

    public void removeEvent(Event event) {
        queue.remove(event);
    }

    public Event getNext() {
        return queue.poll();
    }

    public Event peekNext() {
        return queue.peek();
    }

    public PriorityQueue<Event> getQueue() {
        return queue;
    }
}
