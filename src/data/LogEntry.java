package data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class LogEntry {
	private int revision;
	private Date date;
	private String author;
	private String msg;
	private List<PathAction> paths = new ArrayList<PathAction>();

	public int getRevision() {
		return revision;
	}

	public void setRevision(int revision) {
		this.revision = revision;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public List<PathAction> getPaths() {
		return paths;
	}

	public void setPaths(List<PathAction> paths) {
		this.paths = paths;
	}

	public String getShortMsg() {
		if (getMsg().length() > 80) {
			return getMsg().substring(0, 80) + "...";
		} else {
			return getMsg();
		}
	}

	@Override
	public String toString() {
		return "LogEntry [revision=" + revision + ", date=" + date + ", author=" + author + ", msg=" + msg + ", paths=" + paths + "]";
	}

}
