<!DOCTYPE>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
<head>
	<title>To Do List</title>
	<c:url var="cssHref" value="/css/site.css" />
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/jquery.validate.min.js"></script>
	    <script src="http://cdn.jsdelivr.net/jquery.validation/1.15.0/additional-methods.js "></script>
	    <script src="https://cdn.jsdelivr.net/jquery.timeago/1.4.1/jquery.timeago.min.js"></script>
	    <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	    <script src ="js/passwordValidation.js"></script>
	<link type="text/css" rel="stylesheet" href="${cssHref}"/>
</head>
	<body>
		<form id="newUserSignUp" action="newUserSignUp" method="POST">
		<h1>Create an account to use this super useful todo list</h1>
    		<label for="userName">Enter your Username:</label> <input type="text" name="username"><br/>
    		<label for="password">Enter your Password: </label> <input type="password" name="password"><br/>
    		<label for="confirmPassword">Confirm Password: </label><input type="password" id="confirmPassword" name="confirmPassword"><br/>
    		<input type="submit" value="Sign up"><br/>
		
		</form>
		
				
				
	</body>
</html>