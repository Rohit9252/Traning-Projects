<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home page</title>
</head>
<body>
	<h1>This is home page</h1>
	<h1>Called by home controller</h1>
	<h1>url /home</h1>

	<%
	String n = (String) request.getAttribute("name");
	List<String> c = (List<String>) request.getAttribute("f");
	%>
	<h1>
		Name is
		<%=n%>
	</h1>

	<%
	for (String s : c) {
	%>
		
		<h1><%=s %></h1>


	<%
	}
	%>



</body>
</html>