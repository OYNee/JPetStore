<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<style>
	#selectCat{
		padding : 40;
	}
	
	#catButton{
		padding : 20;
	}

</style>
</head>

<table>
  <tr style="vertical-align:top">
    <td style="text-align:left;width:20%;">
      <table id="main-menu">
        <tr>
          <td><a href='<c:url value="/shop/SellCategory.do"/>'>
            <b><font color="black" size="2">&lt;&lt; BACK</font></b></a></td>
        </tr>
	  </table>
 </td>
 </tr>
 </table>
 
 <center>
<h2>Sale Registration</h2>


    <table width="600" border="0" cellpadding="10" cellspacing="0">
   
        <div><h4>등록할 애완동물의 카테고리를 선택하세요.</h4></div>
        
        <div id="selectCat">
        <form id="category" action="selectCat.do" method="GET">
        <c:forEach var="cat" items="${cats}">
            <input type="radio" name="cat" value="${cat}"/><c:out value="${cat}" />
	    </c:forEach>
	    </div>
	    <input type="hidden" name="isAuction" value="${isAuction}" />
	    <input type="submit" value="NEXT"></input> 
  
		</form>
  	</table>


</center>
 
 