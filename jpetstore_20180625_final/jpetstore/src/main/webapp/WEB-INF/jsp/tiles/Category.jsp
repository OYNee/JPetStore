<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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


</style>

</head>

<table id="main-menu" >
  <tr>
    <td><a href='<c:url value="/shop/index.do"/>'><b>
       <font color="black" size="2">&lt;&lt; Main Menu</font></b></a>
    </td>
  </tr>
</table>

<div align="center">
  <h2><c:out value="${category.name}" /></h2>
  <table class="table table-hover table-bordered thead-dark" style="width:60%">
    <tr bgcolor="#CCCCCC">
      <td><b>Product ID</b></td>
      <td><b>Name</b></td>
      <td><b>DES</b></td>
    </tr>
    <c:forEach var="product" items="${productList.pageList}">
      <tr>
        <td><b><a href='<c:url value="/shop/viewProduct.do">
          <c:param name="productId" value="${product.productId}"/></c:url>'>
            <font color="black"><c:out value="${product.productId}" /></font>
          </a></b></td>
        <td><c:out value="${product.name}" /></td>
        <td><c:out value="${product.description}" /></td>
      </tr>
    </c:forEach>
    
    
    
    <tr>
      <td>
        <c:if test="${!productList.firstPage}">
          <a href='<c:url value="/shop/viewCategory2.do">
            <c:param name="page" value="previous"/></c:url>'>
              <font color="white"><B>&lt;&lt; Prev</B></font></a>
        </c:if> 
        <c:if test="${!productList.lastPage}">
          <a href='<c:url value="/shop/viewCategory2.do">
            <c:param name="page" value="next"/></c:url>'>
              <font color="white"><B>Next &gt;&gt;</B></font></a>
        </c:if>
      </td>
    </tr>
  </table>
</div>
