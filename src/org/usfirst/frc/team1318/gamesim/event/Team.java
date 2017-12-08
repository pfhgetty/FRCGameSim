package org.usfirst.frc.team1318.gamesim.event;

public class Team {
	
	private final Robot robot;
	private final HumanPlayer player;
	
	private Team(Robot robot, HumanPlayer player) {
		this.robot = robot;
		this.player = player;
	}
	
	public Robot getRobot() {
		return this.robot;
	}
	
	public HumanPlayer getPlayer() {
		return this.player;
	}
	
	public static class Builder {
		
		private Robot robot = new Robot();
		private HumanPlayer player = new HumanPlayer();
		
		public Builder() {
			
		}
		
		// why do we have to return Builder?
		public Builder setRobot(Robot robot) {
			this.robot = robot;
			return this;
		}
		
		public Builder setPlayer(HumanPlayer player) {
			this.player = player;
			return this;
		}
		
		public Team build() {
			return new Team(robot, player);
		}
	}
}
