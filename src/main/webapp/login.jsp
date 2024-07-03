<%@include file="includes/header.jsp" %>
<c:url value="/login" var="loginUrl"/>

<form class="px-2" method="post" action="${loginUrl}">
	<input type="text" name="username">
	<input type="password" name="password">
	<button>Submit</button>
</form>
<%@include file="includes/footer.jsp" %>