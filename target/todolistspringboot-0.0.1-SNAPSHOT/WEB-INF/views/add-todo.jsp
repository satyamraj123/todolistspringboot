<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
<h1>Add a todo</h1>
<form:form method="post" action="add-todo" commandName="todo">
<fieldset class="form-group">
<form:label path="desc">Description</form:label>
<form:input path="desc" type="text" class="form-control" required="required"/>
</fieldset>
<form:errors path="desc" cssClass="text-warning" />
<input class="btn btn-success" value="Add" type="submit"/>
</form:form>
</div>
<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>