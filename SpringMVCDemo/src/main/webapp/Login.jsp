<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
</head>
<body>
<h4 align="right"> <a href="index.jsp">Home</a></h4>
<center>
		<br /> <br /> <br />
<h3>
<form action="lc">
<table>
<tr><td>UserId:</td><td><input type="text" name="id"></td></tr>
<tr><td>Password:</td><td><input type="text" name="pass"></td></tr>
<tr><td></td><td><input type="submit" value="login"></td></tr>
</table>
</form>
${invalid}
</h3>
</center>
</body>
</html>