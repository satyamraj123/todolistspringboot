<%@ include file="common/header.jspf"%>
<%@ include file="common/navBar.jspf"%>
<div class="container">
<spring:message code="welcome.caption" /> ${name}.<br>
You can manage to-do list <a href="list-todos">here</a>
</div>
<%@ include file="common/footer.jspf"%>