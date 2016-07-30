package engine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import config.Context;
import data.Branch;

public class SvnRunner {

	public String getLog(Branch branch, Context context) {
		String command = "svn log svn://svn.axit.pl/dev/ax4/branches/" + branch.getName() + " -v --stop-on-copy --xml " + "--username " + context.getSvnUser()
				+ " --password " + context.getSvnPass();

		Runtime rt = Runtime.getRuntime();
		BufferedWriter writer = null;
		try {
			Process process = rt.exec(command);
			InputStream is = process.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));

			StringBuilder sb = new StringBuilder();

			String line;
			while ((line = br.readLine()) != null) {
				sb.append(line);
			}

			br.close();
			FileWriter fw = new FileWriter(context.getLogLocation(branch));
			writer = new BufferedWriter(fw);
			writer.write(sb.toString());
			branch.setLogFileSize(sb.length());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null)
					writer.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return command;
	}
}
