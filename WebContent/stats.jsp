<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="engine.ReportGenerator"%>
    <%@page import="data.*"%>
    <%@page import="config.*"%>

Branches Statistics for AX4 project<br><br>
<jsp:useBean id="reportGenerator" class="engine.ReportGenerator"></jsp:useBean>


<%Report report=reportGenerator.generate(); 
session.setAttribute("report", report); %>
<table border="1px" cellspacing="0px" cellpadding="3px" bordercolor="#FFFFFF">

<tr>
<td width="200px"></td>
<% for(BranchContent branchContent:report.getBranchContents()){
BranchStatistics stats=branchContent.getStatistics();%>
<td width="130px"><b><%=branchContent.getBranch().getOwner() %></b></td>
<%}%></tr>

<tr>
<td>Branch Suffix</td>
<% for(BranchContent branchContent:report.getBranchContents()){%>
<td><%=branchContent.getBranch().getSuffix() %></td>
<%}%></tr>

<tr>
<td>Branch age</td>
<% for(BranchContent branchContent:report.getBranchContents()){%>
<td><%=branchContent.getStatistics().getAge() %> days</td>
<%}%></tr>

<tr>
<td>Oldest commit</td>
<% for(BranchContent branchContent:report.getBranchContents()){%>
<td><%=Utils.format(branchContent.getStatistics().getFirstDate()).replace(" ", "<br>") %></td>
<%}%></tr>

<tr>
<td>Newest commit</td>
<% for(BranchContent branchContent:report.getBranchContents()){%>
<td><%=Utils.format(branchContent.getStatistics().getLastDate()).replace(" ", "<br>") %></td>
<%}%></tr>

<tr>
<td>Revisions</td>
<% for(BranchContent branchContent:report.getBranchContents()){%>
<td><%=branchContent.getStatistics().getNumberOfRevisions() %></td>
<%}%></tr>

<tr>
<td>Modified files</td>
<% for(BranchContent branchContent:report.getBranchContents()){%>
<td><%=branchContent.getStatistics().getTotalFilesModified() %></td>
<%}%></tr>

<tr>
<td>File modifications</td>
<% for(BranchContent branchContent:report.getBranchContents()){%>
<td><%=branchContent.getStatistics().getNumberOfFileModifications() %></td>
<%}%></tr>

<tr>
<td>Most often modified file</td>
<% for(BranchContent branchContent:report.getBranchContents()){%>
<td><%=branchContent.getStatistics().getMostModifiedFile() +"&nbsp("+branchContent.getStatistics().getMostChangesInOneFile()+")"%>
</td>
<%}%></tr>

<tr>
<td >Most common modified files types</td>
<% for(BranchContent branchContent:report.getBranchContents()){%>
<td valign="top">
<% for(FileType ext:branchContent.getStatistics().getFileTypes()){%>
<%=ext.getName()+"&nbsp("+ext.getModification()+")" %><br>
<%} %>
</td>
<%}%></tr>

<tr>
<td>Avg. comment length</td>
<% for(BranchContent branchContent:report.getBranchContents()){%>
<td><%=branchContent.getStatistics().getAvgCommentLength() %></td>
<%}%></tr>

<tr>
<td>Max. comment length</td>
<% for(BranchContent branchContent:report.getBranchContents()){%>
<td><%=branchContent.getStatistics().getTopCommentLength() %></td>
<%}%></tr>



<tr>
<td >Contributors <br>by revisions</td>
<% for(BranchContent branchContent:report.getBranchContents()){%>
<td valign="top">
<% for(Author author:branchContent.getStatistics().getContributorsByRevisions()){%>
<%=author.getName()+"&nbsp("+author.getRevisions()+")" %><br>
<%} %>
</td>
<%}%></tr>

<tr>
<td >Contributors <br>by file modifications</td>
<% for(BranchContent branchContent:report.getBranchContents()){%>
<td valign="top">
<% for(Author author:branchContent.getStatistics().getContributorsByModifiedFiles()){%>
<%=author.getName()+"&nbsp("+author.getModifications()+")" %><br>
<%} %>
</td>
<%}%></tr>






<tr>
<td width="200px"></td>
<% for(BranchContent branchContent:report.getBranchContents()){
BranchStatistics stats=branchContent.getStatistics();%>
<td width="130px"><b><%=branchContent.getBranch().getOwner() %></b></td>
<%}%></tr>

</table>
<br><br>