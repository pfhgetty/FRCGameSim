package org.usfirst.frc.team1318.gamesim.event;

import java.util.ArrayList;
import java.util.List;

public class Event {
	
	private final List<Match> qualifiers;
	private final List<Match> playoffs;
	
	private Event(List<Match> qualifiers, List<Match> playoffs) {
		this.qualifiers = qualifiers;
		this.playoffs = playoffs;
	}
	
	public List<Match> getQualifiers() {
		return qualifiers;
	}
	
	public List<Match> getPlayoffs() {
		return playoffs;
	}
	
	public static class Builder {
		
		private List<Match> qualifiers = new ArrayList<>();
		private List<Match> playoffs = new ArrayList<>();
		
		public Builder() {
			
		}
		
		public Builder setQualifiers(List<Match> qualifiers) {
			this.qualifiers = qualifiers;
			return this;
		}
		
		public Builder setPlayoffs(List<Match> playoffs) {
			this.playoffs = playoffs;
			return this;
		}
		
		public Event build() {
			return new Event(qualifiers, playoffs);
		}
	}
}
