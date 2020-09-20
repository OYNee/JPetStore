<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
%>

<table>
  <tr style="vertical-align:top">
    <td style="text-align:left;width:20%;">
      <table id="main-menu">
        <tr>
          <td><a href='<c:url value="/shop/generalForm.do"/>'>
            <b><font color="black" size="2">&lt;&lt; BACK</font></b></a></td>
        </tr>
	  </table>
 </td>
 </tr>
 </table>
<center>
<h2>Check Your Registration Information</h2>
    <table width="400" border="1" cellpadding="10" cellspacing="0">
        <%--  <tr>
            <td>Image</td>
            <td><img src="../images/uploadImages/${generalItem.image}" style="height:60"/></td>
        </tr> --%>
        
        <tr>
            <td>Item ID</td>
            <td><c:out value="${itemId}" ></c:out></td>
        </tr>
        
        <tr>
            <td>Product ID</td>
            <td>${generalItem.productId}</td>
        </tr>
        
        <tr>
           <td>Category ID</td>
            <td>${generalItem.categoryId}</td>
        </tr>
        
           <tr>
           <td>Title</td>
            <td>${generalItem.itemTitle}</td>
        </tr>
        
       <%--  <tr>
           <td>Name</td>
           <td><c:out value="${generalItem.product.name}" ></c:out></td>
        </tr>
        
        <tr>
           <td>Description</td>
           <td>${generalItem.product.description}</td>
        </tr>
         --%>
          <tr>
            <td>Seller</td>
            <td>${generalItem.seller}</td>
        </tr>
        
        <tr>
            <td>List Price</td>
            <td>${generalItem.listPrice}</td>
        </tr>
        
         <tr>
            <td>Unit Cost</td>
            <td>${generalItem.unitCost}</td>
        </tr>
        
        
          <tr>
            <td>Att1</td>
            <td>${generalItem.attribute1}</td>
        </tr>
        
        <tr>
            <td>Att2</td>
            <td>${generalItem.attribute2}</td>
        </tr>
        
        <tr>
            <td>Att3</td>
            <td>${generalItem.attribute3}</td>
        </tr>
        
        <tr>
            <td>Att4</td>
            <td>${generalItem.attribute4}</td>
        </tr>
        
        <tr>
            <td>Att5</td>
            <td>${generalItem.attribute5}</td>
        </tr>
        
        
         <tr>
           <td>Quantity</td>
            <td>${generalItem.quantity}</td>
        </tr>
        
   
       
    </table>
    <p/>
    <a href='<c:url value="/shop/confirmGeneralSale.do"/>'><button>확인</button></a>
</center>

