package org.usfirst.frc.team1318.gamesim.event;

public class Alliance {
	
	private final Team team1;
	private final Team team2;
	private final Team team3;
	
	private Alliance(Team t1, Team t2, Team t3) {
		this.team1 = t1;
		this.team2 = t2;
		this.team3 = t3;
	}
		
	public Team getTeam1() {
		return this.team1;
	}
	
	public Team getTeam2() {
		return this.team2;
	}
	
	public Team getTeam3() {
		return this.team3;
	}
	
	public static class Builder {
		
		private Team team1 = new Team.Builder().build();
		private Team team2 = new Team.Builder().build();
		private Team team3 = new Team.Builder().build();
		
		public Builder() {
			
		}
		
		public Builder setTeam1(Team team1) {
			this.team1 = team1;
			return this;
		}
		
		public Builder setTeam2(Team team2) {
			this.team2 = team2;
			return this;
		}
		
		public Builder setTeam3(Team team3) {
			this.team3 = team3;
			return this;
		}
		
		public Alliance build() {
			return new Alliance(team1, team2, team3);
		}
	}
}
