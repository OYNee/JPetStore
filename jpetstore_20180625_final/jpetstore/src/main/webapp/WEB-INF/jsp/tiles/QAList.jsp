<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

 <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> -->

<style>
#QA {
	clear:both;
	padding-top : 10px;
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
	padding-right : 30;
	padding-bottom : 10;
}

/* 게시판 */

 #container {
      width: 70%;
      margin: 0 auto;     /* 가로로 중앙에 배치 */
      padding-top: 10%;   /* 테두리와 내용 사이의 패딩 여백 */
    }
     
    #list {
      text-align: center;
    }
   
    #write {
      text-align: right;
    }
     
    /* Bootstrap 수정 */
    .table > thead {
      background-color: #b3c6ff;
    }
    .table > thead > tr > th {
      text-align: center;
    }
    .table-hover > tbody > tr:hover {
      background-color: #e6ecff;
    }
    .table > tbody > tr > td {
      text-align: center;
    }
    .table > tbody > tr > #title {
      text-align: left;
    }
     
    div > #paging {
      text-align: center;
    }
     
    .hit {
      animation-name: blink;
      animation-duration: 1.5s;
      animation-timing-function: ease;
      animation-iteration-count: infinite;
      /* 위 속성들을 한 줄로 표기하기 */
      /* -webkit-animation: blink 1.5s ease infinite; */
    }
     
    /* 애니메이션 지점 설정하기 */
    /* 익스플로러 10 이상, 최신 모던 브라우저에서 지원 */
    @keyframes blink {
      from {color: white;}
      30% {color: yellow;}
      to {color: red; font-weight: bold;}
      /* 0% {color:white;}
      30% {color: yellow;}
      100% {color:red; font-weight: bold;} */
    }


</style>

</head>


</head>
<body>
  
 <div align="center">
  <div id="container">
   
    <div id="list">
      <h2><b>질문 게시판 </b></h2>
    </div>
     
    <div id="QIcon" align="right">
	
	<a href='<c:url value="doingQuestion.do">
	<c:param name="itemId" value="${item.itemId}"/>
	<c:param name="questionId" value="${question.questionId}"/>
	<c:param name="isAuction" value="${item.isAuction}"/></c:url>'>
	      <button class="btn btn-default" id="questionbtn" align="center">
	               <img src="../images/questionicon.png" height="20" />&nbsp;질문하기</button>      
	   </a>
	  </div>
     
    <div>
      <table class="table table-striped table-bordered table-hover">
        <thead>
          <tr>
            <th width="10%">번호</th>
            <th width="50%">제목</th>
            <th width="10%">작성자</th>
            <th width="20%">작성일</th>
        <!--     <th width="10%">조회</th> -->
          </tr>
        </thead>
        <tbody>

        
          <c:forEach var="question" items="${questionList}" varStatus="status">
    <tr>
    <td align="center"><c:out value="${status.count}" /></td>
    
    <td> <a href='<c:url value="/shop/questionClick.do">
            <c:param name="questionId" value="${question.questionId}"/>
            <c:param name="itemId" value="${item.itemId}"/>
            <c:param name="isAuction" value="${item.isAuction}"/>
            </c:url>'>
              <c:out value="${question.title}" />
          </a>
    </td>
    
    <td><c:out value="${question.userId}" /></td>
    <td><fmt:formatDate value="${question.date_time}" pattern="yy/mm/dd" /></td>
	
    </tr>
    </c:forEach>

        </tbody>
      </table>
       
  <!-- 페이징 처리 --><td>
        <c:if test="${!qList.firstPage}">
          <a href="?page=previous"><font color="white"><B>&lt;&lt; Prev</B></font></a>
        </c:if> 
        <c:if test="${!qList.lastPage}">
          <a href="?page=next"><font color="white"><B>Next &gt;&gt;</B></font></a>
        </c:if>
      </td>

    </div>
  </div>

    
   <%--  date 받아오는 법
    <fmt:parseDate value="${item.date}" pattern="yyyy-MM-dd HH:mm:ss" var="date"/>
	<fmt:formatDate value="${date}" pattern="dd/MM/yyyy HH:mm" />
	
	or
	
	<fmt:formatDate value="${item.date}" pattern="dd/MM/yyyy HH:mm" /> --%>
	

</body>
</html>