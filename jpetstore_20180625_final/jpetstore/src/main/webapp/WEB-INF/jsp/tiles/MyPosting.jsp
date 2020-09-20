<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<table style="border:none;border-collapse:collapse;width:100%">
  <tr>
    <td style="text-align:left;vertical-align:top;width:80%">
      <table style="border:none;border-collapse:collapse;width:1400px">
        <tr>
          <td valign="top">                    
          	<%@ include file="MyPageCategory.jsp" %>
          </td>
          <td style="text-align:left; height:350;width:1300px">
          	<br /><br /><br /><br />
			  <div>
		         <div class="mybox">
		         <c:if test="${ tab == '1' }">
		             <div>
			             <table class="nav">
			             	<tr>
		             		
			                    <td class="active" width="80px" style="padding:10px"><a href="?page=0&&tab=1">후기</a></td>
			                    <td width="80px" style="padding:10px; border: 1px solid #cccccc;"><a href="?page=0&&tab=2">Question</a></td>
			                    <td width="80px" style="padding:10px; border: 1px solid #cccccc;"><a href="?page=0&&tab=3">Answer</a></td>
		                    </tr>
		             	</table>
		             </div>
		         </c:if>
		         <c:if test="${ tab == '2' }">
		             <div>
		                <table class="nav">
			             	<tr>    
			                    <td width="80px" style="padding:10px; border: 1px solid #cccccc;"><a href="?page=0&&tab=1">후기</a></td>
			                    <td class="active" width="80px" style="padding:10px"><a href="?page=0&&tab=2">Question</a></td>
			                    <td width="80px" style="padding:10px; border: 1px solid #cccccc;"><a href="?page=0&&tab=3">Answer</a></td>
		                    </tr>
		             	</table>
		             </div>
		         </c:if>
		         <c:if test="${ tab == '3' }">
		             <div>
		                <table class="nav">
			             	<tr>   
			                    <td width="80px" style="padding:10px; border: 1px solid #cccccc;"><a href="?page=0&&tab=1">후기</a></td>
			                    <td width="80px" style="padding:10px; border: 1px solid #cccccc;"><a href="?page=0&&tab=2">Question</a></td>
			                    <td class="active" width="80px" style="padding:10px"><a href="?page=0&&tab=3">Answer</a></td>
		                   
			                </tr>
			             </table>
			         </div>
			     </c:if>
			     <c:if test="${ tab == '1' }">
		             <div>
		             	<table class="salesTable">
			                <tr>
			                    <th width="80px" style="padding:10px; border-bottom: 1px solid #cccccc;">글번호</th>
			                    <th width="200px" style="padding:10px; border-bottom: 1px solid #cccccc;">제목</th>
			                    <th style="padding:10px; border-bottom: 1px solid #cccccc;">판매자</th>
			                    <th style="padding:10px; border-bottom: 1px solid #cccccc;">날짜</th>
			                </tr>
			                
			                <c:forEach var ="r" items="${ reviewList.pageList }" end="9" varStatus="status">
				                <tr>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;">${status.count}</td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;"><a href="#">${r.title}</a></td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;">${r.supp_id}</td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;">${r.datetime}</td>
				                </tr>
			                </c:forEach>
		             	</table>
		             </div>
		             <hr/>
		            <table>
		            	<tr>
					      <td>
		    				<c:if test="${!reviewList.firstPage}">
					          <a href="?page=previous&&tab=1"><font color="black"><B>&lt;&lt;
					                Prev</B></font></a>
					        </c:if> 
					        <span>
							    <c:forEach begin="0" end="${reviewList.pageCount-1}" varStatus="loop">
							    &nbsp;&nbsp;
							    <c:choose>
							        <c:when test="${loop.index == reviewList.page}">${loop.index+1}</c:when>
							        <c:otherwise><a href="?page=${loop.index}&&tab=1">${loop.index+1}</a></c:otherwise>
							    </c:choose>
							    &nbsp;&nbsp;
							    </c:forEach>
						    </span>
					        <c:if test="${!reviewList.lastPage}">
					          <a href="?page=next&&tab=1"><font color="black"><B>Next
					                &gt;&gt;</B></font></a>
					        </c:if></td>
					    </tr>
		            </table>
		         </c:if>
		         <c:if test="${ tab == '2' }">
		             <div>
		             	<table class="salesTable">
			                <tr>
			                    <th width="80px" style="padding:10px; border-bottom: 1px solid #cccccc;">글번호</th>
			                    <th width="200px" style="padding:10px; border-bottom: 1px solid #cccccc;">제목</th>
			                    <th style="padding:10px; border-bottom: 1px solid #cccccc;">item</th>
			                    <th style="padding:10px; border-bottom: 1px solid #cccccc;">날짜</th>
			                </tr>
			                
			                <c:forEach var ="q" items="${ QuestionList.pageList }" end="9" varStatus="status">
				                <tr>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;">${status.count}</td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;"><a style="cursor:pointer"  onclick="viewContent(${q.id});">${ q.title }</a></td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;"><a href="<c:url value="/shop/viewItem.do?itemId=${ q.itemId }"/>">${ q.itemId }</a></td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;">${ q.datetime }</td>
				                    
				                </tr>
				                	
				                <tr>
				                	<td colspan="4">
				                		<div id="${q.id}" style="display:none;"><%@ include file="QAndAContentView.jsp" %></div>
				                	</td>
				                </tr>
			                </c:forEach>
		             	</table>
		             </div>
		             <hr/>
		            <table>
		            	<tr>
					      <td>
		    				<c:if test="${!QuestionList.firstPage}">
					          <a href="?page=previous&&tab=2"><font color="black"><B>&lt;&lt;
					                Prev</B></font></a>
					        </c:if> 
					        <span>
							    <c:forEach begin="0" end="${QuestionList.pageCount-1}" varStatus="loop">
							    &nbsp;&nbsp;
							    <c:choose>
							        <c:when test="${loop.index == QuestionList.page}">${loop.index+1}</c:when>
							        <c:otherwise><a href="?page=${loop.index}&&tab=2">${loop.index+1}</a></c:otherwise>
							    </c:choose>
							    &nbsp;&nbsp;
							    </c:forEach>
						    </span>
					        <c:if test="${!QuestionList.lastPage}">
					          <a href="?page=next&&tab=2"><font color="black"><B>Next
					                &gt;&gt;</B></font></a>
					        </c:if></td>
					    </tr>
		            </table>
		         </c:if>
		         <c:if test="${ tab == '3' }">
		             <div>
		             	<table class="salesTable">
			                <tr>
			                    <th width="80px" style="padding:10px; border-bottom: 1px solid #cccccc;">글번호</th>
			                    <th width="200px" style="padding:10px; border-bottom: 1px solid #cccccc;">제목</th>
			                    <th style="padding:10px; border-bottom: 1px solid #cccccc;">item</th>
			                    <th style="padding:10px; border-bottom: 1px solid #cccccc;">날짜</th>
			                </tr>
			                
			                <c:forEach var ="a" items="${ AnswerList.pageList }" end="9" varStatus="status">
				                <tr>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;">${status.count}</td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;"><a style="cursor:pointer"  onclick="viewContent(${a.id});">${ a.title }</a></td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;"><a href="<c:url value="/shop/viewItem.do?itemId=${ a.itemId }"/>">${ a.itemId }</a></td>
				                    <td style="padding:10px; border-top: 1px solid #cccccc;">${ a.datetime }</td>
				                </tr>
				                <tr>
				                	<td>
				                		<div id="${a.id}" style="display:none;"><%@ include file="QAndAContentView.jsp" %></div>
				                	</td>
				                </tr>
			                </c:forEach>
		             	</table>   
		             </div>
		             <hr/>
		            <table>
		            	<tr>
					      <td>
		    				<c:if test="${!AnswerList.firstPage}">
					          <a href="?page=previous&&tab=3"><font color="black"><B>&lt;&lt;
					                Prev</B></font></a>
					        </c:if> 
					        <span>
							    <c:forEach begin="0" end="${AnswerList.pageCount-1}" varStatus="loop">
							    &nbsp;&nbsp;
							    <c:choose>
							        <c:when test="${loop.index == AnswerList.page}">${loop.index+1}</c:when>
							        <c:otherwise><a href="?page=${loop.index}&&tab=3">${loop.index+1}</a></c:otherwise>
							    </c:choose>
							    &nbsp;&nbsp;
							    </c:forEach>
						    </span>
					        <c:if test="${!AnswerList.lastPage}">
					          <a href="?page=next&&tab=3"><font color="black"><B>Next
					                &gt;&gt;</B></font></a>
					        </c:if></td>
					    </tr>
		            </table>
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

