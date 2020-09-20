<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<center>
	<br/><br/><br/><br/>
	<form method="POST" action='<c:url value="/shop/waitForAdApproval.do"/>' enctype="multipart/form-data">
		<div class="ApplyAdForm">
			<br/><br/>
			이미지 첨부&nbsp;&nbsp;:&nbsp;&nbsp; <input type="file" name="file" accept="image/jpg, image/gif" />
			<br/>
			ad Title = <input type="text" name="title" /><br/>
			<div style="float:left; margin:30px">
				<p>광고 시작 날짜</p>
				<input type="date" value="startDate" name="startDate"/>
			</div>
			<div style="float:right; margin:30px">
				<p>광고 끝나는 날짜</p>
				<input type="date" value="endDate" name="endDate"/><!-- calendar 디자인 하기, 현재는 크롬에서만 달력이 나타남. -->
			</div>
			<br/>
			<input type="hidden" value="${itemid}" name="itemid" />
		</div>
		<p>
			<input type="submit" value="광고 신청" onclick="confirm('입금계좌: xxxxxx-xx-xxxxxx\n입금 기한: xxxx.xx.xx ~ xxxx.xx.xx')"/>
		</p>
	</form>
</center>