 <%@page import="engine.*"%>
  <%@page import="data.*"%>
  <%@page import="config.*"%>
- 
<%
String team=request.getParameter("team");
for(Branch branch:Context.getInstance().getActiveBranches(new Ax4Project())){
if(branch.getOwner().equals(team)){%>[<% } else {%><%}%>
<a href="index.jsp?page=${param.page}&team=<%=branch.getOwner() %>&mode=${param.mode}"><%=branch.getOwner() %></a> 
<% if(branch.getOwner().equals(team)){%>]<%} else {%><%}%>
- 
<%} %>

