package data;

import java.util.ArrayList;
import java.util.List;

public class Report {
	private List<BranchContent> branchContents = new ArrayList<BranchContent>();

	public BranchContent getBranchContent(Branch branch) {
		BranchContent content = null;
		for (BranchContent branchContent : branchContents) {
			if (content.getBranch().equals(branch)) {
				content = branchContent;
			}
		}
		return content;
	}

	public BranchContent getBranchContent(String team) {
		BranchContent content = null;
		for (BranchContent branchContent : branchContents) {
			if (branchContent.getBranch().getOwner().equals(team)) {
				content = branchContent;
			}
		}
		return content;
	}

	public List<BranchContent> getBranchContents() {
		return branchContents;
	}

	public void setBranchContents(List<BranchContent> branchContents) {
		this.branchContents = branchContents;
	}

}
