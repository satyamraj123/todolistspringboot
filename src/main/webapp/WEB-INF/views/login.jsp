<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="login" method="post">
<p><font color="red">${errorMessage}</font></p>
Name: <input type="text" name="name"/><br>
<input type="submit" value="Login"/>
</form>
</body>
</html>