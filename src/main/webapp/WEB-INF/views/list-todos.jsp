<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>To-do List</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
	    		rel="stylesheet">
</head>
<body>
Hi ${name}<br>
<div class="container">
<table class="table table-striped">
<caption>Your to-do's are</caption>

<thead>
<tr>
<th>Index</th>
<th>User Name</th>
<th>Description</th>
<th>Target Date</th>
<th>Completed</th>
<th></th>
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
<td><a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
</tr>
</c:forEach>
</tbody>

</table>
<br>
<a class="btn btn-success" href="add-todo">Add</a>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	    <script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>