<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<style>
#QA {
	clear:both;
	padding-top : 200px;
}

table#questionBoard{
	border: 1px solid black;
}

#questionbtn{
	background-color:#EAEAEA;
	/* border-color: #8A2457 */
    color: black;
    padding: 10px;
    font-size: 16px;
	/* border:groove 1px #D5D5D5; */
	border: none;
    cursor: pointer;
}

#questionbtn:hover
{
    background-color: #4641D9;
    color : #FFFFFF;
}

#QIcon{
	padding-right : 340;
}


</style>
</head>
<div id="QIcon" align="right">

<a href='<c:url value="doingQuestion.do">
<c:param name="itemId" value="${item.itemId}"/>
<c:param name="questionId" value="${question.questionId}"/></c:url>'>
      <button class="btn btn-default" id="questionbtn" align="center">
               <img src="../images/questionicon.png" height="20" />&nbsp;질문하기</button>      
   </a>
  </div>
  
 <div align="center">
  <table id="questionBoard" width="700">
    <tr bgcolor="#CCCCCC" align="center">
      <td width="70"><b>NO.</b></td> <td width="300"><b>Title</b></td>
       <td width="200"><b>Writer</b></td><td width="100"><b>Date</b></td>
      <!-- varStatus 인데 반복문의 상태를 가지는 변수-->
    </tr>
    
    <c:forEach var="question" items="${questionList}" varStatus="status">
    <tr>
    <td align="center"><c:out value="${status.count}" /></td>
    
    <td> <a href='<c:url value="/shop/questionClick.do">
            <c:param name="questionId" value="${question.questionId}"/>
            <c:param name="itemId" value="${item.itemId}"/>
            </c:url>'>
              <c:out value="${question.title}" />
          </a>
    </td>
    
    <td><c:out value="${question.userId}" /></td>
    <td><c:out value="${question.date}"/></td>
	
    </tr>
    </c:forEach>
    
   <%--  date 받아오는 법
    <fmt:parseDate value="${item.date}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
	<fmt:formatDate value="${date}" pattern="dd/MM/yyyy HH:mm" />
	
	or
	
	<fmt:formatDate value="${item.date}" pattern="dd/MM/yyyy HH:mm" /> --%>
    

  </table>
</div>
