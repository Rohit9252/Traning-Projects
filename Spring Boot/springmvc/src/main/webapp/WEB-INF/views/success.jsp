<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>You have been successfully login</h1>
	
	
	<h1>Your name is ${user.userName }</h1>
	<h1>Your Email is ${user.email}</h1>
	<h1> pass word is ${user.userPassword }</h1>

</body>
</html>