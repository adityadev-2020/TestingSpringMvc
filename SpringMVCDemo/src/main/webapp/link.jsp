<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<style type="text/css">
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}
</style>
</head>
<body>
<%
session = request.getSession();
String name = (String) session.getAttribute("user");
%>
<h4 align="right"><%= name %><a href="http://localhost:8080/TransvisionApp/logout"> Logout</a>|<a href="index.jsp">Home</a></h4>
<center>
		<br /> <br /> <br />
<h2>
<a href="Registration.jsp">Registration</a><br>
<a href="http://localhost:8080/TransvisionApp/view">View Student List</a>
</h2>
</center>
</body>
</html>