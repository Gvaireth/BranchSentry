package data;

import java.util.List;

import engine.BranchStatisticsFactory;

public class BranchContent {
	private Branch branch;
	private List<Path> paths;
	private BranchStatistics statistics;

	private List<LogEntry> logEntries;

	public List<LogEntry> getLogEntries() {
		return logEntries;
	}

	public void setLogEntries(List<LogEntry> logEntries) {
		this.logEntries = logEntries;
	}

	public Branch getBranch() {
		return branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	public List<Path> getPaths() {
		return paths;
	}

	public void setPaths(List<Path> paths) {
		this.paths = paths;
	}

	public BranchStatistics getStatistics() {
		if (statistics == null) {
			statistics = BranchStatisticsFactory.generate(this);
		}
		return statistics;
	}

	public String getPathsListing() {
		String result = "";
		int i = 0;
		for (Path path : getPaths()) {
			String revisions = "";
			for (LogEntry logEntry : path.getEntries()) {
				revisions += logEntry.getRevision() + " ";
			}
			result += i + " " + path.getFilename() + " revisions " + path.getEntries().size() + " [" + revisions + "]<br>";
			i++;
		}
		return result;
	}
}
