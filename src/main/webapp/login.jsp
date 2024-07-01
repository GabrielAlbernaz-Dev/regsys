<%@include file="includes/public/header.jsp" %>
<c:url value="/login" var="loginUrl"/>

<form method="post" action="${loginUrl}">
	<input type="text" name="username">
	<input type="password" name="password">
	<button>Submit</button>
</form>
<%@include file="includes/public/footer.jsp" %>