package engine;

import java.util.List;

import config.Ax4Project;
import config.Context;
import data.Branch;
import data.BranchContent;
import data.LogEntry;
import data.Report;

public class ReportGenerator {
	public static Report generate() {
		Report report = new Report();
		try {
			Context context = Context.getInstance();
			XmlLogReader reader = null;

			for (Branch branch : context.getActiveBranches(new Ax4Project())) {
				reader = new XmlLogReader(branch, context);
				List<LogEntry> entries = reader.read();
				BranchContent branchContent = BranchContentFactory.build(branch, entries);
				report.getBranchContents().add(branchContent);
			}

		} catch (Throwable e) {
			e.printStackTrace();
		}

		return report;

	}
}
