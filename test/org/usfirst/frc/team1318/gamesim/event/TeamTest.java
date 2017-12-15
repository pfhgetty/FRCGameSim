package org.usfirst.frc.team1318.gamesim.event;

import static org.junit.Assert.*;

import org.junit.Test;

public class TeamTest {

	@Test
	public void test() {
		Team team = new Team.Builder().build();
		assertNotNull(team.getPlayer());
		assertNotNull(team.getRobot());
	}

}
