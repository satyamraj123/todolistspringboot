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

<table>
<caption>Your todos are</caption>

<thead>
<tr>
<th>Index</th>
<th>User Name</th>
<th>Description</th>
<th>Target Date</th>
<th>Completed</th>
</tr>
</thead>

<tbody>
<c:forEach items="${todos}" var="todo">
<tr>
<td>${todo.id}</td>
<td>${todo.user}</td>
<td>${todo.desc}</td>
<td>${todo.targetDate}</td>
<td>${todo.done}</td>
</tr>
</c:forEach>
</tbody>

</table>
<br>
<a href="add-todo">Add</a>
</body>
</html>