<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<head>

<style>
#topBar{
	background-color : white;
/* 	height: 20%; */
	width : 100%;
}


.btn{
	background-color:#EAEAEA;
	/* border-color: #8A2457 */
    color: black;
    padding: 10px;
    font-size: 16px;
	/* border:groove 1px #D5D5D5; */
	border: none;
    cursor: pointer;
}

.btn:hover
{
    background-color: #3e8e41;
    color : #FFFFFF;
}


.dropbtn
{
    background-color: #EAEAEA;
    color: black;
    padding: 10px;
    font-size: 16px;
    border: none;
    cursor: pointer;
}

.dropbtn:hover{
	color : white;
}

.dropdown
{
    position: relative;
    display: inline-block;
}
.dropdown-content
{
    display: none;
    position: absolute;
    background-color: #f9f9f9;
    min-width: 160px;
    box-shadow: 0px 8px 16px 0px rgba(0,0,0,0.2);
    z-index: 1;
}
.dropdown-content a
{
    color: black;
    padding: 12px 16px;
    text-decoration: none;
    display: block;
}
.dropdown-content a:hover
{
    background-color: #f1f1f1;
}
.dropdown:hover .dropdown-content
{
    display: block;
}
.dropdown:hover .dropbtn
{
    background-color: #3e8e41;
}


</style>

</head>


<table class="topBar"> <!--  class="top"> -->
  <tr>
    <td>
    <div style="margin-right:500">
      <a href="<c:url value="/shop/index.do"/>">
        <img border="0" height="170" src="../images/logo2.png" /></a>
     </div>
    </td>
   
   <div id="mypage">
    <td style="text-align:center">
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
			<a href="#">Administrator</a>
         </div>
      </div>
    </td>
</div>
    
    
  </tr>
</table>

<%-- <%@ include file="IncludeQuickHeader.jsp" %> --%>

