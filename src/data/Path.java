package data;

import java.util.ArrayList;
import java.util.List;

public class Path implements Comparable {
	private String filename;
	private List<LogEntry> entries = new ArrayList<LogEntry>();
	private Branch branch;

	public Path(String filename) {
		super();
		this.filename = filename;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public List<LogEntry> getEntries() {
		return entries;
	}

	public void setEntries(List<LogEntry> entries) {
		this.entries = entries;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((filename == null) ? 0 : filename.hashCode());
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
		Path other = (Path) obj;
		if (filename == null) {
			if (other.filename != null)
				return false;
		} else if (!filename.equals(other.filename))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Path [filename=" + filename + "]";
	}

	@Override
	public int compareTo(Object o) {
		return this.filename.compareTo(((Path) o).getFilename());
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

}
