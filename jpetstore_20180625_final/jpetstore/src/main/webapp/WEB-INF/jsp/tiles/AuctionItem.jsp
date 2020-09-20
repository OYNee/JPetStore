
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

#auction {
   clear:both;
   padding-top : 10px;
}

</style>
</head>
<script>
function auctioned_off_confirm() {
   if(confirm('낙찰된 아이템으로 다시 경매를 진행할 수 없습니다. 현재 입찰가로 경매를 종료하시겠습니까?')) {
      return true;
   }
   document.getElementById("auctionedOffOk").value = "No";
   return false;
}
</script>
<!-- 경매 아이템 상세보기 -->
<div id="menu">
<a href='<c:url value="/shop/viewProduct.do">
        <c:param name="productId" value="${item.productId}"/></c:url>'>
        <b><font color="black" size="2">
          &lt;&lt; <c:out value="${item.product.name}" /></font></b></a>
</div>

<p>
   <center>
   <div height="400">
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
        <Td><b>START_PRICE</b></td><td><c:out value="${item.startPrice}" /></Td>
     </tr>
     <tr>
        <Td><b>START_DATE</b></td><td><c:out value="${item.startDate}" /></Td>
     </tr>
     <tr>
        <Td><b>END_DATE</b></td><td><c:out value="${item.lastDate}" /></Td>
     </tr>
     
     <tr>
        <Td><b>Quantity</b></td><td><c:out value="${item.quantity}" /></Td>
     </tr>
     
     <tr>
    
        <Td><b>SELLER</b>&nbsp;<td><a href='<c:url value="/postList.do">
            <c:param name="sellerid" value="${item.seller}"/>
            </c:url>'><c:out value="${item.seller}"/></a></Td>
   
        <td>
   
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
        <td>
        <c:if test="${ item.status == 'on' }">
        <c:if test="${item.seller != userId }">
          <a href='<c:url value="/shop/partInAuction.do">
            <c:param name="auctionId" value="${item.auctionId}"/>
            <c:param name="itemId" value="${item.itemId}"/></c:url>'>
            <button  class="btn btn-light btn-md">경매 참여하기</button>
          </a>
        </c:if>
        
        <c:if test="${item.seller == userId }">
          <form action="<c:url value='/shop/auctionedOff.do'/>" method="post">
            <input type="hidden" name="isAuction" value="${item.isAuction}"/>
            <input type="hidden" name="auctionId" value="${item.auctionId}"/>
            <input type="hidden" name="itemId" value="${item.itemId}"/>
            <input type="hidden" name="auctionedOffOk" value="Yes" id="auctionedOffOk"/>
            <button class="btn btn-default btn-light btn-md" onclick="auctioned_off_confirm();">낙찰!</button>
          </form>
        </c:if>
      </c:if>
        <c:if test="${ item.status == 'off' }">
          <a href='<c:url value="/shop/partInAuction.do">
            <c:param name="auctionId" value="${item.auctionId}"/>
            <c:param name="itemId" value="${item.itemId}"/></c:url>'>
            <button  class="btn btn-light btn-md">상황 보러가기</button></a>
        </c:if>
        </td>
     
     </tr>
   </table>&nbsp;
   <c:if test="${ item.status == 'off' }">
      <br/>* 경매가 종료된 상품입니다.<br/>현재 거래 진행 상황을 보시려면 '상황 보러가기' 버튼을 누르십시오.
   </c:if>
   </div>
   
   </div>
    
   <div id="auction">
     <!-- 경매상황 차트 넣기 -->
     <h1> Auction Charts </h1>
        <%@ include file="AuctionChart.jsp"%>   
  </div> 


  <div id="QA">
     <%@ include file="QAList.jsp"%>
  </div>

</center>