<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display List</title>
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
		<br /> <br /> <br /> <b>Student List </b><br /> <br />

		<table border="1">
			<tr>
				<td class="heading">Id</td>
				<td class="heading">Name</td>
				<td class="heading">Age</td>
				<td class="heading">Stream</td>
				<td class="heading">Edit</td>
				<td class="heading">Delete</td>
			</tr>
			<c:forEach items="${list}" var="file">
				<tr>
					<td><c:out value="${file.sl }" /></td>
					<td><c:out value="${file.name }" /></td>
					<td><c:out value="${file.age }" /></td>
					<td><c:out value="${file.stream }" /></td>
					<td><a href="edit?sl=${file.sl}">Edit</a></td>
					<td><a href="delete?sl=${file.sl}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="Registration.jsp">New Registration</a>
</body>
</html>