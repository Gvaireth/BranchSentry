package engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import data.Branch;
import data.BranchContent;
import data.Conflict;
import data.Path;
import data.Report;

public class ConflictSeeker {
	public List<Conflict> find() {
		Report report = ReportGenerator.generate();
		List<Path> allPaths = consolidate(report);

		Collections.sort(allPaths);
		List<Conflict> conflicts = new ArrayList<Conflict>();
		boolean consequentConflict = false;
		for (int i = 0; i < allPaths.size() - 1; i++) {
			if (allPaths.get(i).getFilename().equals("")) {
				continue;
			}
			if (allPaths.get(i).getFilename().equals(allPaths.get(i + 1).getFilename())) {
				if (!consequentConflict) {
					consequentConflict = true;
					Conflict conflict = new Conflict();
					conflict.setPath(allPaths.get(i));
					conflict.getBranches().add(allPaths.get(i).getBranch());
					conflict.getBranches().add(allPaths.get(i + 1).getBranch());
					conflicts.add(conflict);
				} else {
					conflicts.get(conflicts.size() - 1).getBranches().add(allPaths.get(i + 1).getBranch());
				}
			} else {
				consequentConflict = false;
			}
		}

		for (Conflict conflict : conflicts) {
			String teams = "";
			for (Branch branch : conflict.getBranches()) {
				teams += branch.getOwner() + " ";
			}
		}
		return conflicts;
	}

	private List<Path> consolidate(Report report) {
		List<Path> allPaths = new ArrayList<Path>();
		for (BranchContent branchContent : report.getBranchContents()) {
			for (Path path : branchContent.getPaths()) {
				path.setBranch(branchContent.getBranch());
			}
			allPaths.addAll(branchContent.getPaths());
			System.out.println(allPaths.size());
		}
		return allPaths;
	}
}
