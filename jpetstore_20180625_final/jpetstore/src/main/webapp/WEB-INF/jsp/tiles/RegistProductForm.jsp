<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<style>
   #selectMenu{
   	width : 400;
   	height : 30;
   }
   
   #select{
   	padding : 50;
   }
   
   select {
    width: 200px;
    height: 30px;
    padding-left: 10px;
    font-size: 18px;
    color: #f63832;
    border: 1px solid #f63832;
    border-radius: 3px;
}
   
</style>



</head>


<table>
  <tr style="vertical-align:top">
    <td style="text-align:left;width:20%;">
      <table id="main-menu">
        <tr>
          <td><a href='<c:url value="/shop/generalForm.do"/>'>
            <b><font color="black" size="2">&lt;&lt; BACK</font></b></a></td>
        </tr>
	  </table>
 </td>
 </tr>
 </table>
<center>
<h2>Sale Registration</h2>
  
  <table width="600" border="0" cellpadding="10" cellspacing="0">
  	  
  	  <form action="selectProduct.do" method="get">
  	  
  	  	  <div> <c:out value="${categoryId}" /> 종류를 선택하시오.</div>
  		
  	<div id="select">
  	<select name="name">
  	<c:forEach var="name" items="${names}" varStatus="status">
  			<option value= "${name}"><c:out value="${name}" /></option>
  	</c:forEach> 
  	</select>
  	</div> 
	
	<input type="hidden" name="isAuction" value="${isAuction}" />
  	<input type="submit" value="NEXT" />
	</form>
  </table>
</center>

