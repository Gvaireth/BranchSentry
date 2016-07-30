package config;

import java.util.ArrayList;
import java.util.List;

public class Config {
	private List<Team> teams = new ArrayList();

	public List<Team> getTeams() {
		return teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	@Override
	public String toString() {
		return "Config [teams=" + teams + "]";
	}

}
