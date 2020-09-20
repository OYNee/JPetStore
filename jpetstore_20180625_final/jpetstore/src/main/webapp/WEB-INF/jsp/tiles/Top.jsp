<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<table class="topBar"> <!--  class="top"> -->
  <tr>
    <td>
    <div style="margin-right:500">
      <a href="<c:url value="/shop/index.do"/>">
        <img border="0" width="350" height="250" src="../images/logo_sy.png" /></a>
     </div>
    </td>
   
   <div id="mypage">
    <td style="text-align:center">
    
    <!--0624 쪽지함 추가 -->
         <a href="<c:url value="/shop/letterView.do"/>">
            <img border="0" name="img_letter" src="../images/letter_icon.png" height="30"/> 
         </a>
    
    
    
    
      <a href="<c:url value="/shop/viewCart.do"/>">
         <button class="btn"> <div margin="auto">
        <img border="0" name="img_cart" src="../images/shoppingCart.png" height="15"/> 
       View Cart</div></button>
          </a>
      <img border="0" src="../images/separator.gif" />
      
      <c:if test="${empty userSession.account}" >
        <a href="<c:url value="/shop/signonForm.do"/>">
         <button class="btn"> <div margin="auto">
            <img border="0" name="img_signin" src="../images/signIn.png" height="15"/> Log In
            </div></button></a>
      </c:if>
      <c:if test="${!empty userSession.account}" >
        <a href="<c:url value="/shop/signoff.do"/>">
          <button class="btn"> <div margin="auto">
            <img border="0" name="img_signin" src="../images/signOut.png" height="15"/> Log Out
            </div></button></a>
        <img border="0" src="../images/separator.gif" />
      </c:if>
      <img border="0" src="../images/separator.gif" />&nbsp;
      
      <%-- <a href="<c:url value="/shop/editAccount.do"/>"> --%>
      <div class="dropdown">
         <button class="dropbtn"> <div margin="auto">
            <img border="0" name="img_signin" src="../images/myAccount.png" height="15"/> My Account
         </div>    
         </button>
         <div class="dropdown-content">
         
			<a href="<c:url value="/shop/editAccount.do"/>">MY PAGE</a>
			<a href="<c:url value="/shop/SellCategory.do"/>">SELL ITEMS</a>
		
         </div>
      </div>
    </td>
</div>
    
    
  </tr>
</table>

<%-- <%@ include file="IncludeQuickHeader.jsp" %> --%>

