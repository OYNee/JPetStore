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
    height:400px;
}

#itemContent {
   width:40%;
   background-color: #ffffff;
    border: none;
    border-spacing: 2px;
    float : left;
   /*  padding-right: 100px; */
}


</style>
</head>
<!-- 일반 아이템 상세보기 -->
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
   <table height="400">
   <tr> 
        <Td><b>product name</b></td><td> <c:out value="${item.product.name}" /></Td>
     </tr>
  
      <tr>
        <Td><b>Item Title</b></td><td> <c:out value="${item.itemTitle}" /></Td>
     </tr>
     
     <tr>
        <Td><b>attribute1</b></td><td> <c:out value="${item.attribute1}" /></Td>
     </tr>
     <tr>
        <Td><b>attribute2</b></td><td> <c:out value="${item.attribute2}" /></Td>
     </tr>
      <tr>
        <Td><b>attribute3</b></td><td> <c:out value="${item.attribute3}" /></Td>
     </tr>
    <%--  <tr>
        <Td><b>item.attribute4</b></td><td> <c:out value="${item.attribute4}" /></Td>
     </tr>
     <tr>
        <Td><b>item.attribute5</b></td><td> <c:out value="${item.attribute5}" /></Td>
     </tr>--%>

     
     <tr>
        <Td><b>PRICE</b></td><td><c:out value="${item.listPrice}" /></Td>
     </tr>
     
       <tr>
        <Td><b>Quantity</b></td><td> <c:out value="${item.quantity}" /></Td>
     </tr>
     
     
     <tr>
    
        <Td><b>SELLER</b>&nbsp;<td><a href="#"><c:out value="${item.seller}"/></a></Td>
   
        <td>
        <a href='<c:url value="/shop/blackList.do">
            <c:param name="seller" value="${item.seller}"/>
            <c:param name="itemId" value="${item.itemId}"/>
            <c:param name="page" value="${ page }"/>
            </c:url>'>
              <button class="btn btn-danger btn-md">
               <img src="../images/emergency.png" height="25"/>신고하기</button>
          </a>
        
        </td>
     </tr>
    
     
   <tr>
        <Td>
        <c:if test="${item.status == 'off'}">
          판매가 마감된 상품입니다.
        </c:if>
        
        <c:if test="${ item.status == 'on' }">
        <c:if test="${item.seller != userId }">
        <a href='<c:url value="/shop/addItemToCart.do">
          <c:param name="workingItemId" value="${item.itemId}"/></c:url>'>
       <button  class="btn btn-light btn-md">Add to Cart </button>
        </a>
        </c:if>
        </c:if>
        </Td>
     
     </tr>
   </table>&nbsp;
   </div>
    

  <div id="QA">
  
     <%@ include file="QAList.jsp"%>
     
  </div>

</center>