<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- SIDEBAR -->
<div style="height:62">
</div>
<table id="index">
	<tr>
		<td>
			<c:if test="${!empty userSession.account}">
				<b><i><font size="4" color="RED">Welcome ${userSession.account.firstName}!</font></i></b>
			</c:if>&nbsp;
		</td>
	</tr>
	<tr>
		<td>
			<a href="<c:url value="/shop/editAccount.do"/>">
				My Account</a>
		</td>
	</tr>
	<tr>
		<td>
			<a href="<c:url value="/shop/listOrders.do"/>">
				My order</a>
		</td>
	</tr>
	<tr>
		<td>
			<a href="<c:url value="/shop/mySales.do"/>">
				My Sales</a>
		</td>
	</tr>
	<tr>
		<td>
			<a href="<c:url value="/shop/myPosting.do"/>">
				My Post</a>
		</td>
	</tr>
</table>