<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<table style="border:none;border-collapse:collapse;width:100%">
  <tr>
    <td style="text-align:left;vertical-align:top;width:80%">
      <table style="border:none;border-collapse:collapse;width:100%">
        <tr>
          <td valign="top">                    
          	<%@ include file="MyPageCategory.jsp" %>
          </td>
          <td style="text-align:left;background-color:white;height:350;width:70%">
			<div align="center"><br /><p><b>Mileage 사용/적립 내역</b></p><hr/>
				<table class="mileageTable">
			        <tr>
			            <th style="padding:10px; border-bottom: 1px solid #cccccc;">Num</th>
			            <th width="80px" style="padding:10px; border-bottom: 1px solid #cccccc;">DATE</th>
			            <th width="200px" style="padding:10px; border-bottom: 1px solid #cccccc;">Description</th>
			            <th style="padding:10px; border-bottom: 1px solid #cccccc;">amount</th>
			        </tr>
			                
			      	<c:forEach var="m" items="${ mileageList.pageList }" end="9" varStatus="status">
				     	<tr>
				      		<td style="padding:10px; border-top: 1px solid #cccccc;"><b>${status.count}</b></td>
				          	<td style="padding:10px; border-top: 1px solid #cccccc;"><b>${m.datetime}</b></td>
				          	<td style="padding:10px; border-top: 1px solid #cccccc;"><b>${ m.description }</b></td>
				        	<td style="padding:10px; border-top: 1px solid #cccccc;"><b>
				        		<c:choose>
									<c:when test="${m.point<0}">
										<font color="red">${ m.point }</font>
									</c:when>
									<c:otherwise>
										<font color="blue">${ m.point }</font>
									</c:otherwise>
								</c:choose>
				        	</b></td>
				    	</tr>
			    	</c:forEach>
			    	<tr>
			    		<td colspan="4" align="right"><br/><hr/>
			    		<table>
		            	<tr>
					      <td><span>page</span>
		    				<c:if test="${!mileageList.firstPage}">
					          <a href="?page=previous"><font color="black"><B>&lt;&lt;
					                Prev</B></font></a>
					        </c:if> 
					        <span>
							    <c:forEach begin="0" end="${mileageList.pageCount-1}" varStatus="loop">
							    &nbsp;&nbsp;
							    <c:choose>
							        <c:when test="${loop.index == mileageList.page}">${loop.index+1}</c:when>
							        <c:otherwise><a href="?page=${loop.index}">${loop.index+1}</a></c:otherwise>
							    </c:choose>
							    &nbsp;&nbsp;
							    </c:forEach>
						    </span>
					        <c:if test="${!mileageList.lastPage}">
					          <a href="?page=next"><font color="black"><B>Next
					                &gt;&gt;</B></font></a>
					        </c:if></td>
					    </tr>
		            </table><td>
			    	</tr>
		    	</table>      
			</div>
    	  </td>
  	    </tr>
	  </table>
	</td>
	<td>
	</td>
  </tr>
</table>

