<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<style>

 .table > thead {
      background-color: #b3c6ff;
    }
   
   .table > thead > tr > th {
      text-align: center;
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
 <div>
<h3>애완동물에 대해 궁금한 점을 질문해주세요.</h3><br>

<div style="width:50%">
<form:form commandName="question" action="successQuestion.do" method="post">
    <table class="table table-bordered">
       <tr bgcolor="white" align="center">
       
   		 <th><form:label path="userId">질문자ID</form:label></th>
         <td><form:hidden path="userId" value="${userId}"/>${userId}
          <form:errors cssStyle="color: red;" path="userId" /></td>

      </tr>
        
      <Tr>

      <th><form:label path="title">제목</form:label></th>
         <td><form:input path="title" size="50"/>
          <form:errors cssStyle="color: red;" path="title" /></td>
      </Tr>
      
      <Tr>
      <th><form:label path="content">질문 내용</form:label></th>
         <td><form:textarea path="content" rows="5" cols="60" />
          <form:errors cssStyle="color: red;" path="content" /></td>
      </Tr>

	  <form:hidden path="itemId" value="${itemId}"/>
	

	</table>
	<input type="hidden" name="isAuction" id="isAuction" value="${isAuction}"/>
	<button type="submit" class="btn btn-primary" onclick="confirm_question();" >질문하기</button>
  </form:form>
 </div> 	
  	</div>
</center>