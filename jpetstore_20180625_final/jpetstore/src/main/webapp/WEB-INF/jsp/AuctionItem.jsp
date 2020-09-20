<%@ include file="IncludeTop.jsp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<head>
<style>
#menu {
 	width:20%;
	background-color: #ffffff;
    border: none;
    border-spacing: 2px;
    float : left;
   /*  padding-right: 200px; */
    /* padding-left: 10px; */
  /*   height : 100%; */
}

#itemImg {
	width:30%;
	background-color: #ffffff;
    border: none;
    border-spacing: 2px;
    float : left;
    padding-right: 30px;
}

#itemContent {
	width:40%;
	background-color: #ffffff;
    border: none;
    border-spacing: 2px;
    float : left;
   /*  padding-right: 100px; */
}

#auction {
	clear:both;
}

</style>
</head>
<!-- 경매 아이템 상세보기 -->
<div id="menu">
<a href='<c:url value="/shop/viewProduct.do">
        <c:param name="productId" value="${item.productId}"/></c:url>'>
        <b><font color="black" size="2">
          &lt;&lt; <c:out value="${item.product.name}" /></font></b></a>
</div>

<p>
   <center>
   <div>

   	<img src="../images/sales_images/${item.image}" id="itemImg"/>
   </div>
   
   <div id="itemContent">
   <table height="300">
   <tr>
     	<Td><b>item Id</b></td><td> <c:out value="${item.itemId}" /></Td>
     </tr>
     
      <tr>
     	<Td><b>product Id</b></td><td> <c:out value="${item.product.productId}" /></Td>
     </tr>
     
     <tr>
     	<Td><b>Description</b></td><td> <c:out value="${item.product.description}" /></Td>
     </tr>
     <tr>
     	<Td><b>attribute1</b></td><td> <c:out value="${item.attribute1}" /></Td>
     </tr>
     <tr>
     	<Td><b>attribute2</b></td><td> <c:out value="${item.attribute2}" /></Td>
     </tr>
    <%--  <tr>
     	<Td><b>item.attribute4</b></td><td> <c:out value="${item.attribute4}" /></Td>
     </tr>
     <tr>
     	<Td><b>item.attribute5</b></td><td> <c:out value="${item.attribute5}" /></Td>
     </tr>--%>
     <tr> 
     	<Td><b>product name</b></td><td> <c:out value="${item.product.name}" /></Td>
     </tr>
     
     <tr>
     	<Td><b>PRICE</b></td><td><c:out value="${item.listPrice}" /></Td>
     </tr>
     
     <tr>
    
     	<Td><b>SELLER</b>&nbsp;<td><a href="#"><c:out value="${item.seller}"/></a></Td>
	
     	<td>
     	<a href='<c:url value="/shop/blackList.do">
            <c:param name="seller" value="${item.seller}"/>
            <c:param name="itemId" value="${item.itemId}"/>
            </c:url>'>
              <button class="btn btn-danger btn-md">
               <img src="../images/emergency.png" height="25"/>신고하기</button>
          </a>
     	
     	</td>
     </tr>
    
     
	<tr>
     	<Td>
  		<a href='<c:url value="/shop/partInAuction.do">
          <c:param name="partAuction" value="${item.itemId}"/></c:url>'>
       <button  class="btn btn-light btn-md">경매 참여하기</button>
     	</a>
     	</Td>
     
     </tr>
   </table>&nbsp;
   </div>
    
   <div id="auction">
  	<!-- 경매상황 차트 넣기 -->
  	<h1> Auction Charts </h1>
  </div> 


  <div id="QA">
  <p><h1> Q & A </h1>
  
  	<%@ include file="QAList.jsp"%>
  	
  </div>

</center>
