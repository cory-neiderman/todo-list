<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>Add Task</title>
	<c:url var="cssHref" value="/css/site.css" />
	<link type="text/css" rel="stylesheet" href="${cssHref}"/>
</head>
	<body>
		<c:url var="formAction" value="/newTask"/>
		<form method="POST" action="${formAction}">
	
		<label for="newTask">Enter your new task:</label> 
		<input type="text" name="taskDescription" id="taskDescription" /><br>
		Enter Priority: <select name="taskPriority">
  			<option value="1">1</option>
 			<option value="2">2</option>
 			<option value="3">3</option>
 		 	<option value="4">4</option>
		</select><br>
		
		Enter due date: <input type="text" name="dueDate" id="dueDate"/><br>
		<input type="submit" name="submit"/>
		</form>
		<br>
	</body>
</html>