<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<script type="text/javascript">
function check_min_price(highestBidPrice) {
	price = document.getElementById("price").value;
	if (highestBidPrice>= price) {
		alert("현재 낙찰가보다 높은 금액을 입력하세요!");
		return;
	}
}
function delete_confirm() {
	if(document.getElementById("myBidPrice").value==0) {
		alert('입찰 내역이 존재하지 않습니다.');
		document.getElementById("deleteOk").value = 'No';
		return false;
	}
	if(confirm("입찰을 취소하시겠습니까?(해당 아이템에 대한 입찰이 모두 취소됩니다.)")) {
		return true;
	}
	document.getElementById("deleteOk").value = 'No';
	return false;
}
</script>

<table>
  <tr style="vertical-align:top">
    <td style="text-align:left;width:20%;">
      
          <td><a href='<c:url value="/shop/goBack.do"/>'>
            <b><font color="black" size="2">&lt;&lt; BACK</font></b></a></td>
        </tr>
</table>


<div align="center">
<h2>경매 참여</h2>

<div>
	<%@ include file="AuctionChart.jsp"%>
	</div>
  <p>현재 입찰가 : ${highestBidPrice} 원</p><!-- 처음에는 스타트, 나중에는 최고가 -->
  <br>

  <table>
    <tr bgcolor="#CCCCCC">
      <td><b>Ranking</b></td>
      <td><b>User ID</b></td>
      <td><b>Bid Price</b></td>
    </tr>
    <c:forEach var="bid" items="${bidList}" begin="0" varStatus="status">
      <tr bgcolor="#FFFF88">
        <td>
       	  ${ status.count }
        </td>
        <td>
          ${ bid.bidder }
        </td>
        <td>
          ${ bid.bid_price }
        </td>
      </tr>
    </c:forEach>
  </table>
  
  <Br>
  <div>
	현재 경매에 참여한 인원 : ${ theNumberOfParticipant } 명<br>
	현재 내 입찰가 : ${ myBidPrice } 원<br>
	</div>
	<c:choose>
	
		<c:when test="${ bidderInfo == 'None' }">
			<div>
			<form action="<c:url value="/shop/updateBid.do"/>" method="POST">
				<input type="hidden" name="itemId" value="${ itemId }">
				<input type="hidden" name="auctionId" value="${ auctionId }">
				<input type="hidden" name="myBidPrice" id="myBidPrice" value="${ myBidPrice }">
				<input type="hidden" name="highestBidPrice" value="${ highestBidPrice }">
				<input type="text" name="price" id="price"/>
				<input type="submit" value="update" name="submit" onclick="check_min_price(${highestBidPrice});"/>
			</form>
			<br/>
			<form action="<c:url value="/shop/deleteBid.do"/>" method="POST">
				<input type="hidden" name="itemId" value="${ itemId }">
				<input type="hidden" name="auctionId" value="${ auctionId }">
				<input type="hidden" name="deleteOk" id="deleteOk" value="Yes"/>
				입찰취소 버튼 : <input type="submit" value="delete" name="submit2" onclick="delete_confirm();"/>
			</form>
			</div>
	    </c:when>
	    <c:otherwise>
	    	<br/>
	    	<b>현재 거래중인 고객 : ${ bidderInfo.bidder }</b><br/>
	    	<b>현재 거래 금액 : ${ bidderInfo.bid_price }</b>
	    	
	    	<br/><br/>
	    	<c:if test="${ bidderInfo.bidder == userId }">
		    	<a href='<c:url value="/shop/addItemToCart.do">
	            <c:param name="workingItemId" value="${itemId}"/></c:url>'>
	            <button  class="btn btn-light btn-md">Add to Cart </button>
	     	    </a>
     	    </c:if>
     	    <!-- 거래 취소하기 버튼 만들자! 근데 취소를 너무 남용하지 못하게 하려면? 마일리지 차감?? -->
	    </c:otherwise>
    </c:choose>
  
</div>

