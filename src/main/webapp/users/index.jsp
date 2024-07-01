<%@include file="../includes/default/header.jsp" %>
	<c:forEach var="user" items="${users}">
		<h4>${user.username()}</h4>
	</c:forEach>
<%@include file="../includes/default/footer.jsp" %>