<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Leaders Home Page</title>
</head>
<body>
	<h2>Leaders Home Page</h2>
	<hr>
	<p>
		See you in Brazil for our annual Leadership retreat! 
		<br> This is
		some secret stuff
	</p>
	<hr>
	<a href="${pageContext.request.contextPath}/">Back to home page</a>
	


</body>
</html>