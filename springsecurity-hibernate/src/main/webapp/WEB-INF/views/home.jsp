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
<title>Home Page</title>
</head>
<body>
	<h2>Hello here this is company home page</h2>
	<hr>
	Hello,
	<security:authentication property="principal.username" />
	<hr>
	Role :
	<security:authentication property="principal.authorities" />
	
	<security:authorize access="hasRole('MANAGER')">
	<hr>
		<p>
			<a href="${pageContext.request.contextPath}/leaders">Leadership
				Meeting</a>(Only for Manager peeps)
		</p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')">
	<hr>
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems
				Meeting</a>(Only for Admin peeps)
		</p>
	</security:authorize>


	<hr>
	<form:form action="${pageContext.request.contextPath}/logout"
		method="post">
		<input type="submit" value="Logout">
	</form:form>
</body>
</html>