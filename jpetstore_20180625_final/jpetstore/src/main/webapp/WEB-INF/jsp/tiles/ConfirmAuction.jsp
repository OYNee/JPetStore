<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
%>

<table>
  <tr style="vertical-align:top">
    <td style="text-align:left;width:20%;">
      <table id="main-menu">
        <tr>
          <td><a href='<c:url value="/shop/auctionForm.do"/>'>
            <b><font color="black" size="2">&lt;&lt; BACK</font></b></a></td>
        </tr>
	  </table>
 </td>
 </tr>
 </table>
<center>
<h2>Check Your Registration Information</h2>
    <table width="400" border="1" cellpadding="10" cellspacing="0">
        
        <tr>
            <td>Item ID</td>
            <td><c:out value="${itemId}" ></c:out></td>
        </tr>
        
        <tr>
            <td>Product ID</td>
            <td>${auctionItem.productId}</td>
        </tr>
        
        <tr>
           <td>Category ID</td>
            <td>${auctionItem.categoryId}</td>
        </tr>
        
  		<%-- <tr>
           <td>Auction Name</td>
           <td><c:out value="${auctionItem.auctionName}" ></c:out></td>
        </tr> --%>
        
        <tr>
           <td>Item Title</td>
           <td><c:out value="${auctionItem.itemTitle}" ></c:out></td>
        </tr> 
     
        <tr>
            <td>Seller</td>
            <td>${generalItem.seller}</td>
        </tr>
        
        <tr>
            <td>Start Price</td>
            <td>${auctionItem.startPrice}</td>
        </tr>
        
         <tr>
            <td>Start Date</td>
            <td>${auctionItem.startDate}</td>
        </tr>
        
        <tr>
            <td>Last Date</td>
            <td>${auctionItem.lastDate}</td>
        </tr>
        
        
          <tr>
            <td>Att1</td>
            <td>${auctionItem.attribute1}</td>
        </tr>
        
        <tr>
            <td>Att2</td>
            <td>${auctionItem.attribute2}</td>
        </tr>
        
        <tr>
            <td>Att3</td>
            <td>${auctionItem.attribute3}</td>
        </tr>
        
        <tr>
            <td>Att4</td>
            <td>${auctionItem.attribute4}</td>
        </tr>
        
        <tr>
            <td>Att5</td>
            <td>${auctionItem.attribute5}</td>
        </tr>
        
         <tr>
            <td>Quantity</td>
            <td>${auctionItem.quantity}</td>
        </tr>
        
   
       
    </table>
    <p/>
    <a href='<c:url value="/shop/confirmAuctionSale.do"/>'><button>확인</button></a>
</center>

