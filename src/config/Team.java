package config;

public class Team {
	private String name;

	public Team(String name, String branch) {
		super();
		this.name = name;
		this.branch = branch;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	private String branch;

	@Override
	public String toString() {
		return "Team [name=" + name + ", branch=" + branch + "]";
	}

}
