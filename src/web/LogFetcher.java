package web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import config.Ax4Project;
import config.Context;
import data.Branch;
import engine.SvnRunner;

/**
 * Servlet implementation class LogFetcher
 */
@WebServlet("/fetch")
public class LogFetcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LogFetcher() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long t1;
		long t2;
		System.out.println("fetch");
		int index = Integer.parseInt(request.getParameter("n"));
		SvnRunner runner = new SvnRunner();
		Context context = Context.getInstance();
		Branch branch = context.getActiveBranches(new Ax4Project()).get(index);
		t1 = System.currentTimeMillis();
		String command = runner.getLog(branch, context);
		t2 = System.currentTimeMillis();
		long size = branch.getLogFileSize() / 1000L;
		long time = t2 - t1;
		String res = "";
		res += "fetching " + branch.getName() + "...<br>";
		res += "saving <b>" + size + " kB</b> to " + Context.getInstance().getLogLocation(branch) + "...<br>";
		res += "done in <b>" + time + " ms</b><br><br>";
		response.getWriter().write(res);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
