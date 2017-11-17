package org.usfirst.frc.team1318.gamesim.event;

import static org.junit.Assert.*;

import org.junit.Test;

public class EventTest {

	@Test
	public void test() {
		Event event = new Event.Builder().build();
		assertNotNull(event.getQualifiers());
		assertNotNull(event.getPlayoffs());
	}

}
