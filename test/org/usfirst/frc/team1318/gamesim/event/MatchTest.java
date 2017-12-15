package org.usfirst.frc.team1318.gamesim.event;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatchTest {

	@Test
	public void test() {
		Match match = new Match.Builder().build();
		assertNotNull(match.getBlue());
		assertNotNull(match.getRed());
	}

}
