<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="engine.ReportGenerator"%>
    <%@page import="data.*"%>
    <%@page import="web.*"%>
    <%@page import="config.*"%>
    <%Report report=ReportGenerator.generate(); %>
    
Branch revisions<br><br> 
<%@include file="/include/teamfilter.jsp"%>
<br><br>
<%String dateam=pageContext.getRequest().getParameter("team"); %> 
<%=Renderer.collapseExpand(pageContext.getRequest().getParameter("mode"),dateam) %>
 <br><br>
<%if(dateam!=null){%>
<table border="1px" cellspacing="0px" cellpadding="3px" bordercolor="#FFFFFF">
 <%int i=report.getBranchContent(dateam).getLogEntries().size();
 boolean expanded="expand".equals(pageContext.getRequest().getParameter("mode"));
 for(LogEntry logEntry:report.getBranchContent(dateam).getLogEntries()){%>
 	 <tr>
 	 <td><%=i--%></td>
 		<%-- <td><a href="index.jsp?page=data&team=${param.team}&rev=<%=i%>"> r<%=logEntry.getRevision()%> </a></td></td>--%>
 		<td>r<%=logEntry.getRevision()%></td>
 		<td width="120px"> <%=Utils.format(logEntry.getDate()) %></td>
 		<td> <%=logEntry.getAuthor()%> </td>
 		<%if(!expanded){ %>
 			<td> <%=logEntry.getShortMsg()%></td>
 		<%}else{ %>
 			<td> <%=logEntry.getMsg()%></td>
 		<%} %>
    </tr>
    <%if(expanded){ %>
    <tr>
    <td colspan="5"> 
    <%for(PathAction path:logEntry.getPaths()){ %>
    	<%=path.getAction()+" "+path.getFilename() %><br>
    <%} %>
    </td>
    </tr>
    <%} %>
 <%}%>
 </table> 
<%}%>