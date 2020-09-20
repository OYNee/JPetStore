<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<table style="border:none;border-collapse:collapse;width:100%">
  <tr>
    <td style="text-align:left;vertical-align:top;width:80%">
      <table style="border:none;border-collapse:collapse;width:100%">
        <tr>
          
          <td valign="top">       
          <c:if test="${!accountForm.newAccount}">             
          	<%@ include file="MyPageCategory.jsp" %>
          	</c:if>
          </td>
          
          <td style="text-align:left;background-color:white;height:350;width:70%">
			<div align="center">
				<form:form commandName="accountForm" method="post">
				  <form:errors cssClass="error" /> <br><br>
				  
				  <table id="account">
				    <tr>
				      <td>
				        <h3><font color="darkgreen">User Information</font></h3>
				        <table class="n13">
				          <tr>
				            <td>User ID:</td>
				            <td>
				            <c:if test="${accountForm.newAccount}">
				              <form:input path="account.user_id" />
				              <B><form:errors path="account.user_id" cssClass="error" /></B>
				            </c:if> 
				            <c:if test="${!accountForm.newAccount}">
				              <c:out value="${accountForm.account.user_id}" />
				            </c:if>
				            </td>
				          </tr>
				          <tr>
				            <td>New password:</td>
				            <td>
				              <form:password path="account.password" /> 
				              <B><form:errors path="account.password" cssClass="error" /></B></td>
				          </tr>
				          <tr>
				            <td>Repeat password:</td>
				            <td>
				              <form:password path="repeatedPassword" /> 
				              <B><form:errors path="repeatedPassword" cssClass="error" /></B></td>
				          </tr>
				          <c:if test="${!accountForm.newAccount}">
				          <tr>
				            <td>Mileage:</td>
				            <td>
				            
				              <a href="<c:url value="/shop/myMileage.do"/>"><c:out value="${accountForm.account.nowMileage}" /></a>
				            
				            </td>
				          </tr>
				          </c:if>
				        </table> 
				        
				        <%@ include file="IncludeAccountFields.jsp"%>
				
				      </td>
				    </tr>
				  </table>
				  <br />
				    <input type="image" src="../images/button_submit.gif" name="submit"
				      value="Save Account Information" />
				</form:form>
				<p></p>
			</div>
    	  </td>
  	    </tr>
	  </table>
	</td>
	<td>
	</td>
  </tr>
</table>

