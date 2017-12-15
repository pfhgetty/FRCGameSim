package org.usfirst.frc.team1318.gamesim.event;

public class Match {

	private final Alliance blueAlliance;
	private final Alliance redAlliance;
	
	private Match(Alliance blueAlliance, Alliance redAlliance) {
		this.blueAlliance = blueAlliance;
		this.redAlliance = redAlliance;
	}
	
	public Alliance getBlue() {
		return this.blueAlliance;
	}
	
	public Alliance getRed() {
		return this.redAlliance;
	}
	
	public static class Builder {
		
		private Alliance blueAlliance = new Alliance.Builder().build();
		private Alliance redAlliance = new Alliance.Builder().build();
		
		public Builder() {
			
		}
		
		public Builder setBlue(Alliance blue) {
			this.blueAlliance = blue;
			return this;
		}
		
		public Builder setRed(Alliance red) {
			this.redAlliance = red;
			return this;
		}
		
		public Match build() {
			return new Match(blueAlliance, redAlliance);
		}
	}
}
