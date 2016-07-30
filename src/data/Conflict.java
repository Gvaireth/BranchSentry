package data;

import java.util.ArrayList;
import java.util.List;

public class Conflict {
	private Path path;
	private List<Branch> branches = new ArrayList<Branch>();

	public List<String> getTeams() {
		List<String> teams = new ArrayList<String>();
		for (Branch branch : getBranches()) {
			teams.add(branch.getOwner());
		}
		return teams;
	}

	public String getTeamsFlat() {
		String ret = "";
		for (String s : getTeams()) {
			ret += s + " & ";
		}
		return ret.substring(0, ret.length() - 3);
	}

	public Path getPath() {
		return path;
	}

	public void setPath(Path path) {
		this.path = path;
	}

	public List<Branch> getBranches() {
		return branches;
	}

	public void setBranches(List<Branch> branches) {
		this.branches = branches;
	}

	@Override
	public String toString() {
		return "Conflict [path=" + path + ", branches=" + branches + "]";
	}

}
