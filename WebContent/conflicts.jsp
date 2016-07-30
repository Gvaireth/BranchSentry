  <%@page import="engine.*"%>
  <%@page import="data.*"%>
  <%@page import="config.*"%>
  <%@page import="java.util.*"%>
<jsp:useBean id="seeker" class="engine.ConflictSeeker"></jsp:useBean>

<%List<Conflict> conflicts=seeker.find(); 
%> 

List of files modified in more than one branch<br><br>

<%@include file="/include/teamfilter.jsp"%>
<a href="index.jsp?page=${param.page}">hit me with all</a> -
<br><br>

<table border="1px" cellspacing="0px" cellpadding="3px" bordercolor="#FFFFFF" frame="box">
<%-- <tr><td></td><td>Teams involved<br><br></td><td>File<br><br></td></tr>--%>
<%

int id=1;
for(int i=0;i<conflicts.size();i++){ 
if(request.getParameter("team")==null||conflicts.get(i).getTeamsFlat().contains(request.getParameter("team"))){
%>
<tr>
<td><%=id %></td>
<td width="200px"><%=conflicts.get(i).getTeamsFlat() %></td>
<td><%=conflicts.get(i).getPath().getFilename() %></td>
</tr>
<%
id++;
}
} %>
</table>