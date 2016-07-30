<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="config.*;" %>

Welcome to Branch Sentry!<br><br>
Created to help developers avoiding merge conflicts way before the code freeze day...<br>
..and explore hidden secrets of our vast repository ;)
<br><br> 
Last data update was on <b><%=Utils.format(Context.getInstance().getLogsModDate()) %></b>.<br><br>
You may now:<br>
<ul>
<li>Click <b>Data</b> to see list of revisions and changed files in active branches.  </li>
<li>Perform <b>Update</b> of data, so logs of active branches will be freshly downloaded from svn. This usually takes several seconds.<br></li>
<li>Witness potential <b>Conflicts</b> that may come up while merging team branches to trunk.<br> </li>
<li>Watch <b>Statistics</b> of currently active branches, lots of interesting numbers lurks here.<br> </li>
<li>Play with <b>Config</b> of various things<br></li>
<li>Check out the <b>Outro</b> before you leave. But you will come back, right?<br><br></li>
<li>And most importantly, have fun!</li>
</ul>
 
<br><br>


   