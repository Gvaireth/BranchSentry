package web;

import javax.servlet.AsyncContext;
import javax.servlet.ServletResponse;

import config.Ax4Project;
import config.Context;
import data.Branch;
import engine.SvnRunner;

public class FetchJob implements Runnable {

	private AsyncContext asyncContext;

	public FetchJob(AsyncContext context) {
		this.asyncContext = context;
	}

	@Override
	public void run() {
		try {
			ServletResponse resp = asyncContext.getResponse();
			resp.getWriter().write("Log update started...<br><br>");
			long t1;
			long t2;

			SvnRunner runner = new SvnRunner();
			Context context = Context.getInstance();
			for (Branch branch : context.getActiveBranches(new Ax4Project())) {
				t1 = System.currentTimeMillis();
				runner.getLog(branch, context);
				t2 = System.currentTimeMillis();
				resp.getWriter().write("Log of " + branch.getName() + " fetch time: " + (t2 - t1) + "ms" + " file size: " + branch.getLogFileSize());
			}
			asyncContext.complete();
			resp.getWriter().write("<a href=start.jsp>Get Back to start</a><br></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
