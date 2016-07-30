package config;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;

import data.Branch;
import data.Project;

public class Context {

	private ServletContext servletContext;

	private static Context instance = new Context();

	public static final String SVNDATA_DIR = "svndata/";
	public static final String BRANCHES = "branches/";

	private Context() {
	}

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public String getFilesRoot() {
		// return "/home/branchsentry/branchsentry/";
		return "D:/branchsentry/";
	}

	public String getSvnUser() {
		return "branchsentry";
	}

	public String getSvnPass() {
		return "password";
	}

	public static Context getInstance() {
		return instance;
	}

	public String getLogLocation(Branch branch) {
		String result = getFilesRoot() + SVNDATA_DIR + branch.getProject().getPrefix() + branch.getName() + ".xml";
		System.out.println(result);
		return result;
	}

	@SuppressWarnings("unchecked")
	public List<Branch> getActiveBranches(Project project) {

		List<Branch> branches = new ArrayList<Branch>();

		branches.add(new Branch("PRZEMOC", "PRZEMOC_SPRINT_3", new Ax4Project()));
		branches.add(new Branch("PSI", "PSI_1304", new Ax4Project()));
		branches.add(new Branch("MOC", "MOC_SPRINT_30", new Ax4Project()));
		branches.add(new Branch("MITOZA", "MITOZA_SPRINT_3", new Ax4Project()));
		branches.add(new Branch("PRZEWAGA", "PRZEWAGA_SPRINT_3", new Ax4Project()));
		branches.add(new Branch("MIS", "MIS_1303", new Ax4Project()));
		Collections.sort(branches);
		return branches;
	}

	public Date getLogsModDate() {
		File log = new File(getLogLocation(getActiveBranches(new Ax4Project()).get(0)));
		return new Date(log.lastModified());
	}
}
