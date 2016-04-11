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
		<form id="newUserSignUp" action="newUserSignUp" method="POST">
		<h1>Create an account to use this super useful todo list</h1>
    		Enter your Username: <input type="text" name="username"><br/>
    		Enter your Password: <input type="text" name="password"><br/>
    		<input type="submit" value="Sign up"><br/>
		
		</form>
		
	</body>
</html>