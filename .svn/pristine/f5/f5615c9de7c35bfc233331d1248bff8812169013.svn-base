package engine;

import java.util.ArrayList;
import java.util.List;

import data.Branch;
import data.BranchContent;
import data.LogEntry;
import data.Path;
import data.PathAction;

public class BranchContentFactory {

	public static BranchContent build(Branch branch, List<LogEntry> logEntries) {
		BranchContent branchContent = new BranchContent();
		List<Path> uniquePaths = getPaths(logEntries);
		branchContent.setBranch(branch);
		branchContent.setPaths(uniquePaths);
		branchContent.setLogEntries(logEntries);
		return branchContent;
	}

	private static List<Path> getPaths(List<LogEntry> logEntries) {
		List<Path> uniquePaths = new ArrayList<Path>();
		for (LogEntry entry : logEntries) {
			for (PathAction pathAction : entry.getPaths()) {
				addOrUpdatePath(uniquePaths, entry, pathAction);
			}
		}
		return uniquePaths;
	}

	private static void addOrUpdatePath(List<Path> uniquePaths, LogEntry entry, PathAction pathAction) {
		int foundIndex = -1;
		int i = 0;
		while (foundIndex == -1 && i < uniquePaths.size()) {
			if (uniquePaths.get(i).getFilename().equals(pathAction.getFilename())) {
				foundIndex = i;
			}
			i++;
		}
		if (foundIndex == -1) {
			uniquePaths.add(new Path(pathAction.getFilename()));
			foundIndex = uniquePaths.size() - 1;
		}
		uniquePaths.get(foundIndex).getEntries().add(entry);
	}
}
