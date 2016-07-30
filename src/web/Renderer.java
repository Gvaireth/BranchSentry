package web;

public class Renderer {
	public static String menuItem(String jsp, String name, String current) {
		if (current == null) {
			current = "start";
		}
		String result = "";
		result += "<tr><td align=\"center\" width=\"100\">";
		if (jsp.equals(current)) {
			result += "[ ";
		}
		result += "<a href=\"index.jsp?page=" + jsp + "\" class=\"mainlink\" >" + name + "</a>";
		if (jsp.equals(current)) {
			result += " ]";
		}
		result += "</td></tr><tr><td><hr></td></tr>";
		return result;
	}

	public static String collapseExpand(String mode, String team) {
		String result = "- ";
		String teamparam = team != null ? "&team=" + team : "";
		boolean expanded = "expand".equals(mode);
		if (expanded)
			result += "[ ";
		result += "<a href=\"index.jsp?page=data" + teamparam + "&mode=expand\">expand</a>";
		if (expanded)
			result += " ]";
		result += " - ";
		if (!expanded)
			result += "[ ";
		result += "<a href=\"index.jsp?page=data" + teamparam + "&mode=collapse\">collapse</a>";
		if (!expanded)
			result += " ]";
		result += " -";
		return result;
	}
}
