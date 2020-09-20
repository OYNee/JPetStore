<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<%@ include file="IncludeTop.jsp"%>

<head>
<style>
#blackList td{
	border : solid 1px black;
}
</style>

<script type="text/javascript" language="javascript" charset="UTF-8">

function confirm_question(){
	  alert("질문 등록이 완료되었습니다.");
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
          <c:param name="itemId" value="${itemId}"/></c:url>'>
                  <b><font color="black" size="2">&lt;&lt;BACK</font></b>
          </a>
          </td>
        </tr>
	  </table>
 </td>
 </tr>
 </table>
 
 <center>
<h2>애완동물에 대해 궁금한 점을 질문해주세요.</h2>

<form:form commandName="question" action="successQuestion.do" method="post">
    <table id="blackList" width="600" align="center">
       <tr bgcolor="white" align="center">
       
   		 <td weight="200"><form:label path="userId">질문자ID</form:label></td>
         <td><form:hidden path="userId" size="20" value="${userId}"/>${userId}
          <form:errors cssStyle="color: red;" path="userId" /></td>

      </tr>
        
      <Tr>

      <td><form:label path="title">제목</form:label></td>
         <td><form:input path="title" size="80" />
          <form:errors cssStyle="color: red;" path="title" /></td>
      </Tr>
      
      <Tr>
      <td><form:label path="content">질문 내용</form:label></td>
         <td><form:textarea path="content" rows="5" cols="80" />
          <form:errors cssStyle="color: red;" path="content" /></td>
      </Tr>

	  <form:hidden path="itemId" value="${itemId}"/>
	</table>
	<input type="submit" value="질문하기" onclick="confirm_question();" />
	
  </form:form>
  	
  
  	
</center>