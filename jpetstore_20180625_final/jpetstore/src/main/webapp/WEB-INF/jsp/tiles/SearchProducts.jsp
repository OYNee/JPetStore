<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table>
    <tr>
        <td valign="top">
			<table id="main-menu" style="width:140px;" >
			  <tr>
			    <td><a href='<c:url value="/shop/index.do"/>'><b>
			      <font color="black" size="2">&lt;&lt; Main Menu</font></b></a></td>
			  </tr>
			</table>
		</td>
	    <td align="center">
			<div align="center" style="width:1000px; padding-left:100px">
			  <br/><p align="left"><b><font size="4">검색 결과</font></b></p><hr/>
			  <table style="width:1000">
			    <tr bgcolor="#FFFF88">
			      <td>&nbsp;</td>
			      <td><b>가격</b></td>
			      <td><b>판매자/판매업체</b></td>
			    </tr>
			    <c:forEach var="product" items="${productList.pageList}">
			      <tr bgcolor="#FFFFD2">
			        <td><a
                         href='<c:url value="/shop/viewProduct.do"><c:param name="productId" value="${product.itemId}"/></c:url>'>
                            <c:out value="${product.attribute1}" escapeXml="false" />
                        </a>
                    </td>
			        <td><b><a
			            href='<c:url value="/shop/viewProduct.do"><c:param name="productId" value="${product.itemId}"/></c:url>'>
			              <font color="BLACK"><c:out value="${product.unitCost}" escapeXml="false" /></font>      <!-- 가격에 대한 정보를 보내줘야 함. -->
			          </a></b></td>
			        <td><font color="BLACK"><c:out value="${product.seller}" escapeXml="false" /></font>  </td>
			      </tr>
			    </c:forEach>
			    <tr>
			      <td>
    				<c:if test="${!productList.firstPage}">
			          <a href="?page=previous"><font color="black"><B>&lt;&lt;
			                Prev</B></font></a>
			        </c:if> 
			        <span>
					    <c:forEach begin="0" end="${productList.pageCount-1}" varStatus="loop">
					    &nbsp;&nbsp;
					    <c:choose>
					        <c:when test="${loop.index == productList.page}">${loop.index+1}</c:when>
					        <c:otherwise><a href="?page=${loop.index}">${loop.index+1}</a></c:otherwise>
					    </c:choose>
					    &nbsp;&nbsp;
					    </c:forEach>
				    </span>
			        <c:if test="${!productList.lastPage}">
			          <a href="?page=next"><font color="black"><B>Next
			                &gt;&gt;</B></font></a>
			        </c:if></td>
			    </tr>
			  </table>
			</div>
		</td>
	</tr>
</table>
