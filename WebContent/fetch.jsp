<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="config.*" %>
    <%@page import="data.*" %>
Data update started, it may take several seconds...<br><br>
<div id='result'></div>
<%--  <%pageContext.include("fetch"); %>--%>
<script type="text/javascript" src="jquery-1.9.1.min.js"></script>
<script type="text/javascript">
var num=0;
var callbacksNum=<%=Context.getInstance().getActiveBranches(new Ax4Project()).size()%>;
getLog(num);

		
 function getLog(num){
 $.ajax({url: 'fetch', 
		success: mycallback,
		data:{n:num},
		error: function(jqXHR, textStatus, errorThrown) {
			alert('err');
			},
		});
 }		
		
 function mycallback(data){
 	$("#result").append(data);
 	num++;
 	if(num<callbacksNum){
 	 getLog(num);
 	}
 	else{
 	$("#result").append('Data update finished successfuly!');
 	}
 }
		</script>
<br><br>