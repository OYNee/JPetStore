<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<center>
	<div style="text-align:center; width:200px;"><br/>
		<h2>Admin Page</h2>
			<ul style="text-align:left;">
				<li><a href="<c:url value="/shop/blackListForAdmin.do"/>">BlackList</a></li>
				<li><a href="<c:url value="/shop/adForAdmin.do"/>">Advertisement</a></li>
			</ul>
	</div>
</center>
