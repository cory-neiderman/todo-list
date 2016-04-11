<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>To Do List</title>
	<c:url var="cssHref" value="/css/site.css" />
	<link type="text/css" rel="stylesheet" href="${cssHref}"/>
</head>
	<body>
		<!-- display todo list -->
		<!-- add task link-->
		<!-- remove task link-->
		<!-- edit task, edit priority, mark as complete -->
		<!-- go to user options -->
		<table>
			<tr>
				<th>Priority</th>
				<th>Name</th>
				<th>Description</th>
				<th>Due Date</th>
			</tr>
		<c:forEach var="task" items="${taskList}">
			<tr>
				<th><c:out value="${task.priority}"/></th>
				<th><c:out value="${task.nameOfCreator}"/></th>
				<th><c:out value="${task.description}"/></th>
				<th><c:out value="${task.dueDateAsString}"/></th>
				
			</tr>
			
		</c:forEach>		
		</table>
  			<a href="addTask">Add a new task</a>
  		
  		<p>
  			<a href="editTask">Edit a task</a>
  		</p>
  		<p>
  			<a href="changeSettings">Change user settings</a>
  		</p>
		
	</body>
</html>