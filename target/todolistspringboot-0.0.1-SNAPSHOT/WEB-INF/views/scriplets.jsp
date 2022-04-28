<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
//any java code
String name=request.getParameter("name");
System.out.println("these are scriplets");
%>
<div>name is <%=name %></div>
</body>
</html>