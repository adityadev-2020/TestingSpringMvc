<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%-- <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update</title>
<style type="text/css">
body {
	font-size: 20px;
	color: teal;
	font-family: Calibri;
}

td {
	font-size: 15px;
	color: black;
	width: 100px;
	height: 22px;
	text-align: center;
}

.heading {
	font-size: 18px;
	color: white;
	font: bold;
	background-color: orange;
	border: thick;
}
</style>
</head>
<body>
<h4 align="right"><a href="http://localhost:8080/TransvisionApp/logout">Logout</a>|<a href="index.jsp">Home</a></h4>
<center>
		<br /> <br /> <br />
<form action="update">
<table>
<tr><td></td><td><input type="hidden" name="sl" value="${edit.sl }"></td></tr>
<tr><td>Name:</td><td><input type="text" name="name" value="${edit.name }"></td></tr>
<tr><td>Stream:</td><td><input type="text" name="stream" value="${edit.stream }"></td></tr>
<tr><td>Age:</td><td><input type="text" name="age" value="${edit.age }"></td></tr>
<tr><td></td><td class="heading"><input type="submit" value="Update"></td></tr>
</table>
<a href="http://localhost:8080/TransvisionApp/view">View Student List</a>
</form>
</center>
</body>
</html>