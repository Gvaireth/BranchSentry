package engine;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import config.Context;
import data.Branch;
import data.LogEntry;
import data.PathAction;

public class LogReader {

	private Branch branch;
	private Context context;

	public LogReader(Branch branch, Context context) {
		this.branch = branch;
		this.context = context;
	}

	public List<LogEntry> read() throws ParserConfigurationException, SAXException, IOException {
		List<LogEntry> logEntries = new ArrayList<LogEntry>();
		File fXmlFile = new File(context.getLogLocation(branch));
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(fXmlFile);
		doc.getDocumentElement().normalize();
		NodeList nList = doc.getElementsByTagName("logentry");

		for (int temp = 0; temp < nList.getLength(); temp++) {
			Node nNode = nList.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				logEntries.add(parseLogEntry(nNode));
			}
		}
		return logEntries;

	}

	private LogEntry parseLogEntry(Node nNode) {
		LogEntry entry = new LogEntry();
		Element eElement = (Element) nNode;
		entry.setRevision(Integer.parseInt(eElement.getAttribute("revision")));
		entry.setAuthor(eElement.getElementsByTagName("author").item(0).getTextContent());
		entry.setMsg(eElement.getElementsByTagName("msg").item(0).getTextContent());
		entry.setDate(parseDate(eElement.getElementsByTagName("date").item(0).getTextContent()));
		NodeList paths = eElement.getElementsByTagName("path");
		for (int i = 0; i < paths.getLength(); i++) {
			addPath(entry, paths, i);
		}
		return entry;
	}

	private void addPath(LogEntry entry, NodeList paths, int i) {
		Node pathNode = paths.item(i);
		PathAction path = new PathAction();
		path.setAction(pathNode.getAttributes().getNamedItem("action").getTextContent());
		String fullFileName = pathNode.getTextContent();
		String trimmedFileName = fullFileName.replace(branch.getProject().getPrefix() + Context.BRANCHES, "");
		trimmedFileName = trimmedFileName.replace(branch.getName(), "");
		trimmedFileName = trimmedFileName.substring(1);
		path.setFilename(trimmedFileName);
		entry.getPaths().add(path);
	}

	private Date parseDate(String date) {
		final String pattern = "yyyy-MM-dd'T'hh:mm:ss";
		final SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		try {
			return sdf.parse(date);
		} catch (ParseException e) {
			throw new IllegalArgumentException("illegal date");
		}
	}
}
