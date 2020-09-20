<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<center>
<div class="mybox">
	<form method="post" name="blackListForm" id="blackListForm" onsubmit="fn_userDel();">
		<table style="width:700px; text-align:center">
			<tr>
				<td>No.</td>
				<td>아이디</td>
				<td>신고당한 페이지</td>		<!-- 블랙리스트에 오를만큼 신고당한 페이지 -->
				<td>리스트에 오른 날짜</td>
				<td>전체 선택<input type="checkbox" name="allcheck" id="allcheck" onclick="allChk(this);"/></td>
			</tr>
			<c:forEach var="b" items="${ blackList }" end="9" varStatus = "status">
			<tr>
				<td>${ status.count }</td>
				<td><a href="<c:url value="/shop/reasonForComplaint.do?id=${ b.blackId }"/>">${ b.blackId }</a></td>
				<td><a href="<c:url value="${ b.page }"/>">${ b.page }</a></td>
				<td>${ b.dateTime }</td>
				<td><input type="checkbox" name="rowCheck" value="${ b.blackId }"/></td>
			</tr>
			</c:forEach>
			
		</table>
		<br/><br/><br/><br/>
		<input type="hidden" value="" id="checkList" name="removeUser"/>
		<input type="submit" value="delete" name="submit"/>
	</form>
</div>
</center>