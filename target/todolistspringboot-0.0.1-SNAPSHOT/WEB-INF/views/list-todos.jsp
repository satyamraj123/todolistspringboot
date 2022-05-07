<%@ include file="common/header.jspf"%>
<%@ include file="common/navBar.jspf"%>


Hi ${name}<br>
<div class="container">
<table class="table table-striped">
<caption><spring:message code="todo.caption" /></caption>

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
<td><fmt:formatDate pattern="dd/MM/yyyy" value="${todo.targetDate}" /></td>
<td>${todo.isDone}</td>
<td>
<a href="update-todo?id=${todo.id}" class="btn btn-info">Update</a>
<a href="delete-todo?id=${todo.id}" class="btn btn-danger">Delete</a></td>
</tr>
</c:forEach>
</tbody>

</table>
<br>
<a class="btn btn-success" href="add-todo">Add</a>
</div>
<%@ include file="common/footer.jspf"%>