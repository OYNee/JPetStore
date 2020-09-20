<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<center>
<div class="mybox">
	<form method="post" name="adListForm" id="adListForm">
		<table style="width:700px; text-align:center">
			<tr>
				<td>No.</td>
				<td>아이디</td>
				<td>아이템 페이지</td>
				<td>신청 기간</td>
				<td>전체 선택<input type="checkbox" name="allcheck" id="allcheck" onclick="allChk(this);"/></td>
			</tr>
			<c:forEach var="a" items="${ adList }" end="9" varStatus = "status">
			<tr>
				<td>${ status.count }</td>
				<td>${ a.seller }</td>
				<td><a href="<c:url value="/shop/viewItem.do?itemId=${ a.itemid }"/>">${ a.itemid }</a></td>
				<td>${ a.startDate } ~ ${ a.endDate }</td>
				<td><input type="checkbox" name="rowCheck" value="${ a.itemid }"/></td>
			</tr>
			</c:forEach>
			
		</table>
		<br/><br/><br/><br/>
		<input type="hidden" id="approvalList" name="approvalList"/>
		<input type="hidden" id="rejectList" name="rejectList"/>
		<input type="submit" value="승인" name="submit" onclick="fn_adApproval();"/>
		<input type="submit" value="거부" name="submit2" onclick="fn_adReject();"/>
	</form>
</div>
</center>