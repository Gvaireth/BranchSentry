package data;

public class Branch implements Comparable {
	private String owner;
	private String name;
	private Project project;
	private long logFileSize;

	public Branch() {
		// TODO Auto-generated constructor stub
	}

	public Branch(String owner, String name, Project project) {
		super();
		this.owner = owner;
		this.name = name;
		this.project = project;
	}

	public String getSuffix() {
		return name.substring(owner.length());
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public long getLogFileSize() {
		return logFileSize;
	}

	public void setLogFileSize(long logFileSize) {
		this.logFileSize = logFileSize;
	}

	@Override
	public String toString() {
		return "Branch [owner=" + owner + ", name=" + name + ", project=" + project + ", logFileSize=" + logFileSize + "]";
	}

	@Override
	public int compareTo(Object o) {
		return getName().compareTo(((Branch) o).getName());
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Branch other = (Branch) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (project != other.project)
			return false;
		return true;
	}

}
