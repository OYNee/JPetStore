<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table style="border:none;border-collapse:collapse;width:100%">
  <tr>
    <td style="text-align:left;vertical-align:top;width:80%">
      <table style="border:none;border-collapse:collapse;width:100%">
        <tr>
          <td valign="top">                    
          	<%@ include file="MyPageCategory.jsp" %>
          </td>
          <td style="text-align:left;background-color:white;height:350;width:70%">
			
			<div align="center">
			<br/><br/>
			  <p>
			    <font size="4"><b>My Orders</b></font>
			  </p>
			  <table class="n23">
			    <tr bgcolor="#CCCCCC">
			      <td><b>Order ID</b></td> <td><b>Date</b></td> <td><b>Total Price</b></td>
			    </tr>
			    <c:forEach var="order" items="${orderList}" end="9">
			      <tr bgcolor="#FFFF88">
			        <td>
			          <b><a href='<c:url value="/shop/viewOrder.do">
			              <c:param name="orderId" value="${order.orderId}"/></c:url>'>
			              <font color="black"><c:out value="${order.orderId}" /></font>
			            </a></b></td>
			        <td><fmt:formatDate value="${order.orderDate}"
			            pattern="yyyy/MM/dd hh:mm:ss" /></td>
			        <td><fmt:formatNumber value="${order.totalPrice}"
			            pattern="$#,##0.00" /></td>
			      </tr>
			    </c:forEach>
			  </table><br /><br /><br /><br /><br />
			  <p>
			    <font size="4"><b>참여중인 경매</b></font>
			  </p>
			  <table class="n23">
			    <tr bgcolor="#CCCCCC">
			      <td><b>Num</b></td> <td><b>Item</b></td> <td><b>My Bid/Current Bid</b></td> <td><b>date</b>
			    </tr>
			    <c:forEach var="bid" items="${bidList}" varStatus="status" end="9">
			      <tr bgcolor="#FFFF88">
			        <td>
			          <b>${status.count}</b></td>
			        <td><b><a href="<c:url value="/shop/viewItem.do?itemId=${ bid.itemId }&isAuction=on"/>">
			              <font color="black"><c:out value="${bid.itemId}" /></font>
			            </a></b></td>
			        <td><fmt:formatNumber value="${bid.bid_price}"
			            pattern="$#,##0.00" />/<fmt:formatNumber value="${bid.highestBidPrice}"
			            pattern="$#,##0.00" /></td>
			        <td>${bid.bid_date}</td>		<!-- format이 안 먹힌다. -->
			          
			      </tr>
			   
			    </c:forEach>
			  </table>
			  
			</div>

    	  </td>
  	    </tr>
	  </table>
	</td>
	<td>
	</td>
  </tr>
</table>
