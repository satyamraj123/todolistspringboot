<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Todo List</title>
</head>
<body>
Hi ${name}<br>
Your todos are
<br>
<c:forEach items="${todos}" var="todo">
${todo.id} ${todo.user} ${todo.desc} <br>
</c:forEach>
<br>
<a href="add-todo">Add</a>

</body>
</html>