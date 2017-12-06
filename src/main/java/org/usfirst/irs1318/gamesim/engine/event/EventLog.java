package org.usfirst.irs1318.gamesim.engine.event;

import java.time.Instant;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class EventLog {
    private final List<Entry> entries = Collections.emptyList();

    public void addEntry(Entry entry) {
        this.entries.add(entry);
    }

    public static final class Entry {
        private final Instant instant;
        private final Map<String, String> content;

        public Entry(Instant instant, Map<String, String> content) {
            this.instant = instant;
            this.content = content;
        }

        public Instant getInstant() {
            return instant;
        }

        public Map<String, String> getContent() {
            return content;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "instant=" + instant +
                    ", content=" + content +
                    '}';
        }
    }
}
