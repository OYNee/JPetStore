<%@ include file="IncludeTop.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<head>
<style>
#Qcontent{
	background-color:#FAF4C0;
	width : 800;
	height : 130;
	text-align:center;
}

#Acontent{
	background-color:white;
	width : 800;
	text-align:center;
}

table td {
	align : center;
}


</style>
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
 <h2> 질문에 대한 답변입니다.</h2>
 
  <table width="800">
  <tr bgcolor="#CCCCCC" align="center">
      <td width="100">Q NO</td>
      <td width="100">ITEM NO</td>
      <td>TITLE</td>
      <td>WRITER</td>
      <td>DATE</td>
  </tr>
  <Tr>
  	 <td><c:out value="${question.questionId}" /></td>
  	 <td><c:out value="${question.itemId}" /></td>
  	 <td><c:out value="${question.title}" /></td>
  	 <td><c:out value="${question.userId}" /></td>
  	 <td><c:out value="${question.date}" /></td>
  </Tr>
  </table>
  <div id="Qcontent">
   <c:out value="${question.content}" />
   </div>
   
   
   
    <div id="Acontent">
   아직 등록된 답변이 없습니다.
   </div>
   <table width="800">
  <tr bgcolor="#CCCCCC" align="center">
      <td width="100">A<c:out value="${answer.answerId}" /></td>
      <td width="100">Q<c:out value="${question.questionId}" /></td>
      <td><c:out value="${answer.answerWriter}" /></td>
      <td><c:out value="${answer.date}" /></td>

  </tr>
  </table>
   
</center>
