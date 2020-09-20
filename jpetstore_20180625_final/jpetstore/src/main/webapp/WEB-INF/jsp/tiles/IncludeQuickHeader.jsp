<%@ page contentType="text/html; charset=utf-8" %>
<center>
	<form action="<c:url value="/shop/searchProducts.do"/>" method="post">
		<div>
			<a id="serach_option_btn" onclick="optionVisable();" href="#" >
				<B>option</B>&nbsp;
			</a>
			<div style="background-color:#660033; display:inline; padding-bottom:12; padding-top:5;">
		    	<input type="hidden" name="search" value="true"/>
		    
		        &nbsp;&nbsp;<input type="text" name="keyword" size="50" />&nbsp;
		        
		        
		        <input src="../images/search.gif" type="image" height="25" align="center"/>&nbsp;&nbsp;<br />
		        
	        </div>
	        <br>
        </div>
        <div id="opt_list" style="display: none;">
        	<table>
        	<tr>
        		<td width=100>array </td>
        		<td>ascending_order<input type="radio" name="array" value="asc" checked="checked" />&nbsp;&nbsp;&nbsp;
        			descending_order<input type="radio" name="array" value="desc" /></td>
        	</tr>
        	<tr>
        		<td width=100>price </td>
        		<td><input type="text" name="price_min" size="14" /> ~ <input type="text" name="price_max" size="14" /></td>
        	</tr>
        	<tr>
        		<td width=100>search by </td>
        		<td>product<input type="radio" name="option" value="product" checked="checked" />&nbsp;&nbsp;&nbsp;
        			seller<input type="radio" name="option" value="seller" /></td>
        	</tr>
        	</table>
        </div>
	</form>


</center>
