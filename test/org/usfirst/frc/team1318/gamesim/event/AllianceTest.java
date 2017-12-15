package org.usfirst.frc.team1318.gamesim.event;

import static org.junit.Assert.*;

import org.junit.Test;

public class AllianceTest {

	@Test
	public void test() {
		Alliance alliance = new Alliance.Builder().build();
		assertNotNull(alliance.getTeam1());
		assertNotNull(alliance.getTeam2());
		assertNotNull(alliance.getTeam3());
	}

}
