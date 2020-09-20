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

<script type="text/javascript" language="javascript" charset="UTF-8">

function confirm_question(){
	  alert("답변 등록이 완료되었습니다.");
	}

</script>

</head>

<table>
  <tr style="vertical-align:top">
    <td style="text-align:left;width:20%;">
      <table id="main-menu">
        <tr>
          <td>
          <a href='<c:url value="/shop/viewItem.do">
          <c:param name="questionId" value="${questionId}"/>
          <c:param name="itemId" value="${itemId}"/>
           <c:param name="isAuction" value="${isAuction}"/></c:url>'>
                  <b><font color="black" size="2">&lt;&lt;BACK</font></b>
          </a>
          </td>
        </tr>
	  </table>
 </td>
 </tr>
 </table>
 
 <center>
<h2>답변하기</h2>

<form:form commandName="answer" action="successAnswer.do" method="post">
    <table id="blackList" width="600" align="center">
 
      <Tr>
      <td><form:label path="content">답변 내용</form:label></td>
         <td><form:textarea path="content" rows="5" cols="80" />
          <form:errors cssStyle="color: red;" path="content" /></td>
      </Tr>

	  <form:hidden path="questionId" value="${questionId}"/>
	  <form:hidden path="answerWriter" value="${writer}"/>

	</table>
	<input type="submit" value="등록하기" onclick="confirm_question();" />
<%-- 	<input type="hidden" name="questionId" id="itemId" value="${questionId}"/> --%>
	<input type="hidden" name="itemId" id="itemId" value="${itemId}"/>
	<input type="hidden" name="isAuction" id="isAuction" value="${isAuction}"/>
  </form:form>
  	
  
  	
</center>