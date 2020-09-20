<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>


<head>
<style>
#blackList td{
	border : solid 1px black;
}
</style>
</head>

<table>
  <tr style="vertical-align:top">
    <td style="text-align:left;width:20%;">
      <table id="main-menu">
        <tr>
          <td>
          <a href='<c:url value="/shop/viewItem.do"><c:param name="itemId" value="${itemId}"/></c:url>'>
                  <b><font color="black" size="2">&lt;&lt;BACK</font></b>
          </a>
          </td>
        </tr>
	  </table>
 </td>
 </tr>
 </table>
 
 <center>
<h2>Report Black List 블랙리스트 신고하기</h2>

<form:form commandName="blackList" action="blackListForm.do" method="post">
    <table id="blackList" width="600" align="center">
       <tr bgcolor="white" align="center">
       
   		<td><form:label path="blackId" style="padding-right:50px;">신고자 ID</form:label>
   		<form:input path="blackId" value="${blackId}" />
       	<form:errors cssStyle="color: red;" path="blackId" /></td>
      </tr>
        
      
      <c:forEach var="reason" items="${reasons}">
      <tr>
       <Td width="800"><form:radiobutton path="blackReason" value="${reason}"/><c:out value="${reason}" /></Td>
       </tr>
      </c:forEach>
  	
	  <form:hidden path="complainant" value="${complainant.user_id}"/>
	  <form:hidden path="page" value="${page}"/>
	 
		<%-- <Tr>
		<td>신고 시간</td>
		<td><c:set var = "now" value = "<%= new java.util.Date()%>" />
		<fmt:formatDate pattern = "yy/MM/dd"  value = "${now}" />
		<form:hidden path="dateTime" value= "<%= new java.util.Date()%>"/></td>
		</Tr> --%>
		 </table>	 
		 <br>
		 <div>
		 <b><font size="12">신고하기 전에 잠깐!</font></b>
		 <p>신고하시면 해당 게시물은 삭제될 수 있으며, 글쓰기 또한 금지될 수 있습니다.<br>
		 	허위 신고의 경우 신고자의 활동에 제한을 받게 되니 이점 유의해 주시기 바랍니다.</p>
		 
		 </div>

		<input type="submit" value="신고하기" />
	
  
  	</form:form>
  	
  
  	
</center>