<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<head>
<style>
 .table > thead {
      background-color: #b3c6ff;
    }
    .table > thead > tr > th {
      text-align: center;
    }
    .table-hover > tbody > tr:hover {
      background-color: #e6ecff;
    }
    .table > tbody > tr > td {
      text-align: center;
    }
    .table > tbody > tr > #title {
      text-align: left;
    }

#viewItem td{
	margin: 100px 0px;
	align:center;
	font-size:70;
}
 
</style>

</head>

<table id="main-menu">
  <tr>
    <td><a href='<c:url value="/shop/viewCategory.do">
        <c:param name="categoryId" value="${product.categoryId}"/></c:url>'>
        <b><font color="black" size="2">
          &lt;&lt; <c:out value="${product.name}" /></font></b></a>
    </td>
  </tr>
</table>

<div align="center">
  <b><font size="4"><c:out value="${product.name}" /></font></b>
  <!-- <table class="n23"> -->
  <table class="table table-bordered table-hover" style="width:60%">
    <tr bgcolor="#CCCCCC">
      <td><b>Image</b></td>
  <!--     <td><b>Product ID</b></td>
      <td><b>Product Name</b></td> -->
      <td><b>Item</b></td>
      <td><b>가격</b></td>
      <td>&nbsp;</td>
    </tr>
    <c:forEach var="item" items="${itemList.pageList}">
      <!-- <tr bgcolor="#FFFF88"> -->
      <tr class="viewItem">
      <td><img src="../images/sales_images/${item.image}" width="90" height="100" /></td>
   
        <td verticle-align="middle">
        <div><h3> 
          <a href='<c:url value="/shop/viewItem.do?itemId=${item.itemId}&isAuction=${item.isAuction}"/>'>
              <c:out value="${item.itemTitle}" />
          </a></h3></div>
          <div>${item.attribute1} / ${item.attribute2} / ${item.attribute3}</div>
        </td>
   
        <td verticle-align="middle">
        <%-- <fmt:formatNumber value="${item.listPrice}" pattern="$#,##0.00" /> --%>
          <c:choose>
			<c:when test="${item.isAuction=='on'}">
				<h3 color="red"><p>경매 상품</p></h3>
			</c:when>
			<c:otherwise>
				<div><br><h4><c:out value="${item.listPrice}" /></h4></div>
			</c:otherwise>
        </c:choose>
        </td>
       
        <td>
        <div style="margin: 30px 0px;">
        <c:choose>
        <c:when test="${ item.quantity < 0 }">
          be out of stock
        </c:when>
        <c:otherwise>
        <c:choose>
			<c:when test="${item.isAuction=='on'}">
				<h3 color="red"><p>경매 상품</p></h3>
			</c:when>
			<c:otherwise>
				<a href='<c:url value="/shop/addItemToCart.do">
            <c:param name="workingItemId" value="${item.itemId}"/></c:url>'>
              <img border="0" src="../images/shoppingCart.png" height="30" />
          </a>
			</c:otherwise>
        </c:choose>
        
        
        </c:otherwise>
        </c:choose>
         
          </div>
      </tr>
    </c:forEach>
    <tr>
      <td>
        <c:if test="${!itemList.firstPage}">
          <a href="?page=previous"><font color="white"><B>&lt;&lt; Prev</B></font></a>
        </c:if> 
        <c:if test="${!itemList.lastPage}">
          <a href="?page=next"><font color="white"><B>Next &gt;&gt;</B></font></a>
        </c:if>
      </td>
    </tr>
  </table>
</div>