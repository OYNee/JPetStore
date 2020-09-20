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
</head>

<table>
  <tr style="vertical-align:top">
    <td style="text-align:left;width:20%;">
      <table id="main-menu">
        <tr>
          <td><a href='<c:url value="/shop/selectCat.do"/>'>
         <%-- <c:param name="categoryId" value="${categoryId}"></c:param> --%>
            <b><font color="black" size="2">&lt;&lt; BACK</font></b></a></td>
        </tr>
	  </table>
 </td>
 </tr>
 </table>
<center>
<h2>Auction Sale Registration</h2>


<form:form commandName="auctionItem" action="auctionSave.do" method="post" enctype="multipart/form-data">
    <table width="400" border="1" cellpadding="10" cellspacing="0">
    
   <div id="showProductInfo">
    <div id="title">
    <form:hidden path="categoryId" value="${product.categoryId}" />
    <c:out value="${product.categoryId}"/></div>
    <div id="title"><c:out value="${product.name}"/></div>
	<div><form:hidden path="productId" value="${product.productId}"/></div>
	<div><form:hidden path="itemId" value="${itemId}"/></div> 
	</div>
		<tr>
            <td><form:label path="itemTitle">Item Title</form:label></td>
            <td><form:input path="itemTitle" size="20"/>&nbsp;
            <form:errors cssStyle="color: red;" path="itemTitle" /></td>
        </tr>
        
	 	<tr>
            <td>Seller</td>
            <td>${seller}</td>
        </tr>
	
		<tr>
			<td>Image</td>
			<td><input type="file" name="files"></td>
		</tr>
		
		 <tr>
            <td><form:label path="itemTitle">Title</form:label></td>
            <td><form:input path="itemTitle" size="20"/>&nbsp;
            <form:errors cssStyle="color: red;" path="itemTitle" /></td>
        </tr>
        
         <tr>
            <td><form:label path="startPrice">start Price</form:label></td>
            <td><form:input path="startPrice" size="20"/>&nbsp;
            <form:errors cssStyle="color: red;" path="startPrice" /></td>
        </tr>
        
         <tr>
            <td><form:label path="startDate">Start Date</form:label></td>
            <td><form:input path="startDate" size="20"/>&nbsp;
            <form:errors cssStyle="color: red;" path="startDate" /></td>
        </tr>
        
         <tr>
            <td><form:label path="lastDate">Last Date</form:label></td>
            <td><form:input path="lastDate" size="20"/>&nbsp;
            <form:errors cssStyle="color: red;" path="lastDate" /></td>
        </tr>
        
         <tr>
            <td><form:label path="auctionName">Auction Name</form:label></td>
            <td><form:input path="auctionName" size="20"/>&nbsp;
            <form:errors cssStyle="color: red;" path="auctionName" /></td>
        </tr>
        
         <tr>
            <td><form:label path="attribute1">Att 1</form:label></td>
            <td><form:input path="attribute1" size="20"/>&nbsp;
            <form:errors cssStyle="color: red;" path="attribute1" /></td>
        </tr>
        
        <tr>
            <td><form:label path="attribute2">Att 2</form:label></td>
            <td><form:input path="attribute2" size="20"/>&nbsp;
            <form:errors cssStyle="color: red;" path="attribute2" /></td>
        </tr>
        
        <tr>
            <td><form:label path="attribute3">Att 3</form:label></td>
            <td><form:input path="attribute3" size="20"/>&nbsp;
            <form:errors cssStyle="color: red;" path="attribute3" /></td>
        </tr>
        
        <tr>
            <td><form:label path="attribute4">Att 4</form:label></td>
            <td><form:input path="attribute4" size="20"/>&nbsp;
            <form:errors cssStyle="color: red;" path="attribute4" /></td>
        </tr>
        
        <tr>
            <td><form:label path="attribute5">Att 5</form:label></td>
            <td><form:input path="attribute5" size="20"/>&nbsp;
            <form:errors cssStyle="color: red;" path="attribute5" /></td>
        </tr>
        
        <tr>
            <td><form:label path="quantity">Quantity</form:label></td>
            <td><form:input path="quantity" size="20"/>&nbsp;
            <form:errors cssStyle="color: red;" path="quantity" /></td>
        </tr>
        

    </table>

    <input type="submit" value="경매 등록"/>
</form:form>
</center>

