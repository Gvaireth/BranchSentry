package web;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import config.Context;

/**
 * Servlet Filter implementation class Activity
 */
@WebFilter("/*")
public class Activity implements Filter {
	Logger logger = Logger.getLogger(this.getClass());

	/**
	 * Default constructor.
	 */
	public Activity() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		logActivity(request);

		chain.doFilter(request, response);
	}

	private synchronized void logCounter() throws IOException {
		String cntFileName = Context.getInstance().getFilesRoot() + "logs/counter.txt";
		File cntFile = new File(cntFileName);
		cntFile.createNewFile();
		BufferedReader br = new BufferedReader(new FileReader(cntFile));
		String counter = br.readLine();
		if (counter == null || counter.length() == 0) {
			counter = "0";
		}
		int cnt = Integer.parseInt(counter);
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(cntFile)));
		out.print(++cnt);
		out.close();
	}

	private void logActivity(ServletRequest request) throws IOException {
		String logfile = Context.getInstance().getFilesRoot() + "logs/activity.txt";
		HttpServletRequest req = (HttpServletRequest) request;
		String info = new Date() + "|" + req.getRemoteHost() + "|" + req.getRequestURI();
		if (req.getQueryString() != null) {
			info += "?" + req.getQueryString();
		}
		if (req.getRequestURI().contains("index") || req.getRequestURI().equals("/BranchSentry/")) {
			PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(logfile, true)));
			out.println(info);
			out.close();
			System.out.println(info);
			logCounter();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
