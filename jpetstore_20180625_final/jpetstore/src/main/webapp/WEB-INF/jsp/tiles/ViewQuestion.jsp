<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
  <style>
   
    /* Bootstrap 수정 */
    .table > thead {
      background-color: #b3c6ff;
    }
    .table > thead > tr > th {
      text-align: center;
    }
   /*  .table-hover > tbody > tr:hover {
      background-color: #e6ecff;
    } */
    .table > tbody > tr > td {
      text-align: center;
    }
    .table > tbody > tr > #title {
      text-align: left;
    }
     
    div > #paging {
      text-align: center;
    }
  </style>
</head>
<body>
<!--   <form action="/bbs/replyForm.bbs" method="post"> -->
    <div align="center">
      
        <div>
       <h3> Item Id : ${itemId}</h3><br>
        </div>
         
      <table class="table table-bordered" style="width: 50%">
        <tr>
          <th>글쓴이</th>
          <td>${question.userId}</td>
           <th>날짜</th>
          <td><fmt:formatDate value="${question.date_time}" pattern="yy/mm/dd" /></td>
          <%-- <th>조회수</th>
          <td>${article.hit}</td> --%>
        </tr>
        <tr>
          <th>제목</th>
          <td colspan="3">${question.title}</td>

        </tr>
     
        <tr height="200" valign="top">
          <td colspan="4">${question.content}</td>
        </tr>
        <%-- <tr>
          <th>첨부</th>
          <td colspan="3">
            <c:if test="${article.fileName == null}">없음</c:if>
            <c:if test="${article.fileName != null}">${article.fileName}</c:if>
          </td>
        </tr> --%>     
      </table>
      
      <c:choose>
			<c:when test="${empty answerList}">
			<br>
			<div>아직 등록된 답변이 없습니다. </div>
			<br>
			</c:when>
			
			<c:otherwise>
			<c:forEach var="answer" items="${answerList}" varStatus="status">
			<table  class="table table-bordered table-hover" style="width: 50%" >
			    <tr>
			    <td align="center"><c:out value="${status.count}" /></td>
			    
			    <td> 
			              <c:out value="${answer.content}" />
			    </td>
			    
			    <td><c:out value="${answer.answerWriter}" /></td>
			    <td><fmt:formatDate value="${answer.date_time}" pattern="yy/mm/dd" /></td>
				
			    </tr>
			   </table>
	</c:forEach>
			
			</c:otherwise>
	</c:choose>
      
     
      
      <div>
      <a href='<c:url value="/shop/writeAnswer.do">
      		<c:param name="questionId" value="${question.questionId}"/>
      		<c:param name="itemId" value="${itemId}"/>
            <c:param name="isAuction" value="${isAuction}"/>
       
            </c:url>'>
              <button class="btn btn-warning" >답글달기</button>
          </a>
      <a href='<c:url value="/shop/viewItemBack.do">
            <c:param name="itemId" value="${itemId}"/>
            <c:param name="isAuction" value="${isAuction}"/>
            </c:url>'>
              <button class="btn btn-primary" >목록으로</button>
          </a>
          </div>
    </div>
<!--   </form> -->
 
</body>
</html>
