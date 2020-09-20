<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<center>
<h2>${ username }님이 신고당한 이유</h2>
<div class="mybox">
	<table style="width:700px; text-align:center">
		<tr>
			<td>No.</td>
			<td>신고당한 페이지</td>
			<td>이유</td>
		</tr>
		<c:forEach var="r" items="${ reasonList }" end="9" varStatus = "status">
			<tr>
				<td>${ status.count }</td>
				<td>${ r.page }</td>
				<td>${ r.blackReason }</td>
			</tr>
		</c:forEach>
	</table>
	<br/><br/><br/><br/>
</div>
</center>