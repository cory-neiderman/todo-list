<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>Finalize Task</title>
	<c:url var="cssHref" value="/css/site.css" />
	<link type="text/css" rel="stylesheet" href="${cssHref}"/>
</head>
	<body>
		<c:url var="formAction" value="/finalizeNewTask"/>
		<form method="POST" action="${formAction}">
		<p>This is the information for your new  task.  Click submit to finalize</p>
		<ul>
			<li>Name: <c:out value="${task.nameOfCreator}"/></li>
			<li>Details: <c:out value="${task.description}"/></li>
			<li>Priority: <c:out value="${task.priority}"/></li>
		</ul>
		<input type="submit" name="Submit"/>
		</form>
		<br>
	</body>
</html>