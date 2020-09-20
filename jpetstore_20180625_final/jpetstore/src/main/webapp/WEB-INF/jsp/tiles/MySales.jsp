<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<head>
<script type="text/javascript" language="javascript" charset="UTF-8">

	function complete(){
		  alert("삭제가 완료되었습니다.");
		}
</script>
</head>

<table style="border:none;border-collapse:collapse;width:100%">
  <tr>
    <td style="text-align:left;vertical-align:top;width:80%">
      <table style="border:none;border-collapse:collapse;width:1400px">
        <tr>
          <td valign="top">
          	<%@ include file="MyPageCategory.jsp" %>
          </td>
          <td style="text-align:left;background-color:white;height:350;width:1300px">
		    <div>
		      <br /><br /><br /><br />
		         <div class="mybox">
		         <c:if test="${ tab == '1' }">
		         	<div>
		             	<table class="nav">
		             		<tr>
			                    <td class="active" width="80px" style="padding:10px;"><a href="?page=0&&tab=1">판매중</a></td>
			                    <td class="inactive" width="80px" style="padding:10px;"><a href="?page=0&&tab=2">판매완료</a></td>
		                	</tr>
		             	</table>
		             </div>
		         </c:if>
		         <c:if test="${ tab=='2' }"> 	
		             <div>
		             	<table class="nav">
		             		<tr>
			                    <td class="inactive" width="80px" style="padding:10px; border: 1px solid #cccccc;"><a href="?page=0&&tab=1">판매중</a></td>
			                    <td class="active" width="80px" style="padding:10px"><a href="?page=0&&tab=2">판매완료</a></td>
		                	</tr>
		             	</table>
		             </div>
		          </c:if>
		          <c:if test="${ tab=='1' }">
		             <div>
		             	<table class="salesTable">
			                <tr>
			                    <th width="80px" style="padding:10px; border-bottom: 1px solid #cccccc;">글번호</th>
			                    <th width="200px" style="padding:10px; border-bottom: 1px solid #cccccc;">item</th>
			                    <th style="padding:10px; border-bottom: 1px solid #cccccc;">가격</th>
			                    <th style="padding:10px; border-bottom: 1px solid #cccccc;">광고</th>
			                    <th style="padding:10px; border-bottom: 1px solid #cccccc;">&nbsp;</th>
			                   <th style="padding:10px; border-bottom: 1px solid #cccccc;">&nbsp;</th>
			                </tr>
			                
			                <c:forEach var="sales" items="${salesList1.pageList}" varStatus="status">
				                <tr>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;">${status.count}</td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;"><a href="<c:url value="/shop/viewItem.do?itemId=${ sales.itemid }&&isAuction=${ sales.isAuction }"/>"><c:out value="${sales.itemid}" /></a></td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;"><c:out value="${sales.unitcost}" /></td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;">
				                    	<c:choose>
											<c:when test="${sales.adStatus=='2'}">
												광고 중<!-- 나중에 광고 이미지 교체 가능한 페이지로 이동  -->
											</c:when>
											<c:when test="${sales.adStatus=='1'}">
												<a href="<c:url value="/shop/waitForAdApproval.do?itemid=${sales.itemid}"/>">승인 대기</a><!-- 광고 신청 후에 뜨는 화면 -->
											</c:when>
											<c:otherwise>
												<a href="<c:url value="/shop/applyAd.do?itemid=${sales.itemid}"/>">광고 신청</a>
											</c:otherwise>
										</c:choose>
									</td>
									
									
									<!-- 180623 -->
									<td style="padding:10px; border-top: 1px solid #cccccc;">
				                    	<c:choose>
											<c:when test="${sales.isAuction=='on'}">
												경매
											</c:when>
											<c:otherwise>
												일반
											</c:otherwise>
										</c:choose>
									</td>
									
									<td style="padding:10px; border-top: 1px solid #cccccc;">
										<a href='<c:url value="/shop/deleteItem.do">
								        <c:param name="itemId" value="${sales.itemid}"/></c:url>'>
								         <input type="button" value="삭제" onClick="complete();"/>
								        </a>
								        <a href='<c:url value="/shop/updateItem.do">
								        <c:param name="itemId" value="${sales.itemid}"/></c:url>'>
								         <input type="button" value="수정" />
								        </a>
									</td>
									
				                </tr>
			                </c:forEach>
			            </table>
			            <hr />
			            
		            <!-- 페이징 처리 -->
		            <table>
		            	<tr>
					      <td>
		    				<c:if test="${!salesList1.firstPage}">
					          <a href="?page=previous&&tab=1"><font color="black"><B>&lt;&lt;
					                Prev</B></font></a>
					        </c:if> 
					        <span>
							    <c:forEach begin="0" end="${salesList1.pageCount-1}" varStatus="loop">
							    &nbsp;&nbsp;
							    <c:choose>
							        <c:when test="${loop.index == salesList1.page}">${loop.index+1}</c:when>
							        <c:otherwise><a href="?page=${loop.index}&&tab=1">${loop.index+1}</a></c:otherwise>
							    </c:choose>
							    &nbsp;&nbsp;
							    </c:forEach>
						    </span>
					        <c:if test="${!salesList1.lastPage}">
					          <a href="?page=next&&tab=1"><font color="black"><B>Next
					                &gt;&gt;</B></font></a>
					        </c:if></td>
					    </tr>
		            </table>
		            <!-- 여기까지가 페이징 -->
		            </div>
		            </c:if>
		            <c:if test="${ tab=='2' }">
		            <div>
		                <table class="salesTable">
			                <tr>
			                    <th width="80px" style="padding:10px; border-bottom: 1px solid #cccccc;">글번호</th>
			                    <th width="200px" style="padding:10px; border-bottom: 1px solid #cccccc;">item</th>
			                    <th style="padding:10px; border-bottom: 1px solid #cccccc;">완료 날짜</th>
			                    <th style="padding:10px; border-bottom: 1px solid #cccccc;">거래 금액</th>
			                </tr>
			                
			                <c:forEach var="sales" items="${salesList2.pageList}" varStatus="status">
				                <tr>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;">${ (salesList2.pageCount-salesList2.page)*salesList2.pageSize-(status.count-(salesList2.pageCount*salesList2.pageSize)) }</td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;"><a href="<c:url value="/shop/viewItem.do?itemId=${ sales.itemid }&&isAuction=${ sales.isAuction }"/>">${sales.itemid}</a></td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;">2017-04-18</td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;">${sales.unitcost}</td>
				                </tr>
			                </c:forEach>
		                </table>  
		                <hr />
		            <!-- 페이징 처리 -->
		            <table>
		            	<tr>
					      <td>
		    				<c:if test="${!salesList2.firstPage}">
					          <a href="?page=previous&&tab=2"><font color="black"><B>&lt;&lt;
					                Prev</B></font></a>
					        </c:if> 
					        <span>
							    <c:forEach begin="0" end="${salesList2.pageCount-1}" varStatus="loop">
							    &nbsp;&nbsp;
							    <c:choose>
							        <c:when test="${loop.index == salesList2.page}">${loop.index+1}</c:when>
							        <c:otherwise><a href="?page=${loop.index}&&tab=2">${loop.index+1}</a></c:otherwise>
							    </c:choose>
							    &nbsp;&nbsp;
							    </c:forEach>
						    </span>
					        <c:if test="${!salesList2.lastPage}">
					          <a href="?page=next&&tab=2"><font color="black"><B>Next
					                &gt;&gt;</B></font></a>
					        </c:if></td>
					    </tr>
		            </table>
		            <!-- 여기까지가 페이징 -->
		              </div>
		            </c:if>
		         </div>
		    </div>
		    
		  </td>
		</tr>
	  </table>
	</td>
	<td>
	</td>
  </tr>
</table>