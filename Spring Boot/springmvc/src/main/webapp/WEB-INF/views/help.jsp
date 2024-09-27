<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored = "false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>This is help Section</h1>


	<%
	/* String name = (String) request.getAttribute("name"); */
	%>

	<h2>My name is :-
	 ${name}
	 </h2>
	 
	 
	 <h2>Time and date is  ${time }</h2>
	 
	 <hr>
	 
	 
	 <c:forEach var="item" items="${list }">
	  
	  <h3>${item}</h3>
	 
	 </c:forEach>
	 
	 

</body>
</html>