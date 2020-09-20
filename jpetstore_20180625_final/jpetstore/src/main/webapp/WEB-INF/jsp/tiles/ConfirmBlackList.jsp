
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table>
  <tr style="vertical-align:top">
    <td style="text-align:left;width:20%;">
      <table id="main-menu">
        <tr>
          <td><a href='<c:url value="/shop/blackList.do"/>'>
            <b><font color="black" size="2">&lt;&lt; BACK</font></b></a></td>
        </tr>
	  </table>
 </td>
 </tr>
 </table>
 
 
<center>
<h2>Black List 신고가 완료되었습니다.</h2>
    <table width="400" border="1" cellpadding="10" cellspacing="0">
        
        <tr>
            <td>BlackList ID</td>
            <td>${blackList.blackId}</td>
        </tr>
        
        <tr>
            <td>신고 사유</td>
            <td><c:out value="${blackList.blackReason}" ></c:out></td>
        </tr>
        
    </table>
    <p/>
    <a href='<c:url value="/shop/index.do"/>'><button>확인</button></a>

</center>

