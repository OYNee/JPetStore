<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<style>

 #showProductInfo {
	/* border : 2px solid #f63832; */
	background :#FFEAEA;
	padding : 20;
	width : 400;
	margin-bottom : 30;
}

#title {
	font-size : 20;
	font-weight: bold;
	padding : 5;
}

</style>

<script type="text/javascript" language="javascript" charset="UTF-8">

	function complete(){
		  alert("경매 ITEM 수정이 완료되었습니다.");
		}
</script>
</head>

<table>
  <tr style="vertical-align:top">
    <td style="text-align:left;width:20%;">
      <table id="main-menu">
        <tr>
          <td><a href='<c:url value="/shop/mySales.do"/>'>
            <b><font color="black" size="2">&lt;&lt; BACK</font></b></a></td>
        </tr>
	  </table>
 </td>
 </tr>
 </table>
<center>
<h2>Auction Item 수정</h2>


<form:form commandName="auctionItem" action="updateAuctionItem.do" method="post" enctype="multipart/form-data">
    <table width="400" border="1" cellpadding="10" cellspacing="0">
    
    <div id="showProductInfo">
    <div id="title">
    ITEM ID <c:out value="${item.itemId}"/></div>
    AUCTION ID <c:out value="${item.auctionId}"/></div>
 	<form:hidden path="itemId" value="${item.itemId}"/></div>
	</div>
	
		<tr>
            <td><form:label path="itemTitle">Item Title</form:label></td>
            <td><form:input path="itemTitle" size="20" value="${item.itemTitle}"/>
            <form:errors cssStyle="color: red;" path="itemTitle" /></td>
        </tr>
        <Tr>
        	<td>Image</td>
        	<Td><img src="../images/sales_images/${item.image}" width="400" height="400"></Td>
        </Tr>
        
       <%--   <tr>
            <td><form:label path="auctionId">Auction ID</form:label></td>
            <td><form:input path="auctionId" size="20" value="${item.auctionId}"/>
            <form:errors cssStyle="color: red;" path="auctionId" /></td>
        </tr> --%>
        
         <tr>
            <td><form:label path="startPrice">Start Price</form:label></td>
            <td><form:input path="startPrice" size="20" value="${item.startPrice}"/>
            <form:errors cssStyle="color: red;" path="startPrice" /></td>
        </tr>
        
         <tr>
            <td><form:label path="startDate">Start Date</form:label></td>
            <td><form:input path="startDate" size="20" value="${item.startDate}"/>
            <form:errors cssStyle="color: red;" path="startDate" /></td>
        </tr>
        
         <tr>
            <td><form:label path="lastDate">Last Date</form:label></td>
            <td><form:input path="lastDate" size="20" value="${item.lastDate}" />
            <form:errors cssStyle="color: red;" path="lastDate" /></td>
        </tr>
        
         <tr>
            <td><form:label path="attribute1">Att 1</form:label></td>
            <td><form:input path="attribute1" size="20" value="${item.attribute1}"/>
            <form:errors cssStyle="color: red;" path="attribute1" /></td>
        </tr>
        
        <tr>
            <td><form:label path="attribute2">Att 2</form:label></td>
            <td><form:input path="attribute2" size="20" value="${item.attribute2}"/>
            <form:errors cssStyle="color: red;" path="attribute2" /></td>
        </tr>
        
        <tr>
            <td><form:label path="attribute3">Att 3</form:label></td>
            <td><form:input path="attribute3" size="20" value="${item.attribute3}"/>
            <form:errors cssStyle="color: red;" path="attribute3" /></td>
        </tr>
        
        <tr>
            <td><form:label path="attribute4">Att 4</form:label></td>
            <td><form:input path="attribute4" size="20" value="${item.attribute4}"/>
            <form:errors cssStyle="color: red;" path="attribute4" /></td>
        </tr>
        
        <tr>
            <td><form:label path="attribute5">Att 5</form:label></td>
            <td><form:input path="attribute5" size="20" value="${item.attribute5}"/>
            <form:errors cssStyle="color: red;" path="attribute5" /></td>
        </tr>
        
        <tr>
            <td><form:label path="quantity">Quantity</form:label></td>
            <td><form:input path="quantity" size="20" value="${item.quantity}"/>
            <form:errors cssStyle="color: red;" path="quantity" /></td>
        </tr>

    </table>
    <p/>
    <input type="submit" value="경매 판매 수정" onClick="complete();"/>
</form:form>
</center>

