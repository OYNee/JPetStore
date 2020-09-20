<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>




<style>
table#index tr td#cat:hover {
    padding: 20px; 
    background : #FFD8D8;
}
</style>

			<script>
				$(document).ready(function(){
					$('.slider').bxSlider({
						auto: true,
						captions: true,
				    	slideWidth: 370,
				    	pager: false,
				    	controls: false,
				    	mode: 'fade',
				    	adaptiveHeight: true,
				    	infiniteLoop: true
					});
					$('.slider2').bxSlider({
						auto: true,
						captions: true,
				    	slideWidth: 370,
				    	pager: false,
				    	controls: false,
				    	mode: 'fade',
				    	adaptiveHeight: true,
				    	infiniteLoop: true
					});
					$('.slider3').bxSlider({
						auto: true,
						captions: true,
						pager: true,
						slideWidth: 1400,
						infiniteLoop: true,
						autoHover: true
						
					});
					$('.sliderItem1').bxSlider({
						auto: true,
						captions: true,
				    	slideWidth: 280,
				    	pager: false,
				    	controls: false,
				    	mode: 'fade',
				    	infiniteLoop: true,
				    	slideMargin: 10
					});
					$('.sliderItem2').bxSlider({
						auto: true,
						captions: true,
				    	slideWidth: 280,
				    	pager: false,
				    	controls: false,
				    	mode: 'fade',
				    	infiniteLoop: true,
				    	slideMargin: 10
					});
					$('.sliderItem3').bxSlider({
						auto: true,
						captions: true,
				    	slideWidth: 280,
				    	pager: false,
				    	controls: false,
				    	mode: 'fade',
				    	infiniteLoop: true,
				    	slideMargin: 10
					});
					$('.sliderItem4').bxSlider({
						auto: true,
						captions: true,
				    	slideWidth: 280,
				    	pager: false,
				    	controls: false,
				    	mode: 'fade',
				    	infiniteLoop: true,
				    	slideMargin: 10
					});
					$('.sliderItem5').bxSlider({
						auto: true,
						captions: true,
				    	slideWidth: 300,
				    	pager: false,
				    	controls: false,
				    	mode: 'fade',
				    	infiniteLoop: true
					});
					$('.sliderItem6').bxSlider({
						auto: true,
						captions: true,
				    	slideWidth: 130,
				    	pager: false,
				    	controls: false,
				    	mode: 'fade',
				    	infiniteLoop: true
					});
					
				});
			</script>
			
<table style="border:none;border-collapse:collapse;width:1500px">
  <tr>
    <td style="text-align:left;vertical-align:top">
      <table style="border:none;border-collapse:collapse;width:100%">
        <tr>
          <td valign="top" width="300px">                    
            <!-- SIDEBAR -->
           	<table id="index">
              <tr>
                <td>
                <c:if test="${!empty userSession.account}">
			       <b><i><font size="4" color="RED">Welcome ${userSession.account.user_id}!</font></i></b>
                </c:if>&nbsp;
                </td>
              </tr>
              
     
              <tr>
                <td id="cat">
                <a href="<c:url value="/shop/viewCategory.do?categoryId=FISH"/>"> 
                   <!-- <div><B>FISH</B></div> -->
                   <img border="0" src="../images/fish_icon.gif" />
                </a>
                </td>
              </tr>
     
              <tr>
                <td id="cat">
                  <a href="<c:url value="/shop/viewCategory.do?categoryId=DOGS"/>">
                    <img border="0" src="../images/dogs_icon.gif" />
                    <!-- <b>DOG</b> --></a>
                </td>
              </tr>
              <tr>
                <td id="cat">
                  <a href="<c:url value="/shop/viewCategory.do?categoryId=CATS"/>">
                    <img border="0" src="../images/cats_icon.gif" />
                    <!-- <B>CAT</B> --></a>
                </td>
              </tr>
              <tr>
                <td id="cat">
                  <a href="<c:url value="/shop/viewCategory.do?categoryId=REPTILES"/>">
                    <img border="0" src="../images/reptiles_icon.gif" />
                    <!-- <B>REPTILES</B> --></a>
                </td>
              </tr>
              <tr>
                <td id="cat">
                  <a href="<c:url value="/shop/viewCategory.do?categoryId=BIRDS"/>">
                    <img border="0" src="../images/birds_icon.gif" />
                    <!-- <B>BIRDS</B> --></a>
                </td>
              </tr>
            </table>
          </td>
          <td style="text-align:center;height:300;width:100%">
		    <div class="slider3" style="text-align:center;">
					<div><a href="<c:url value="/shop/viewCategory.do?categoryId=FISH"/>"><img src="../images/fish/fish_banner5.png" title="FISH"/></a></div>
					<div><a href="<c:url value="/shop/viewCategory.do?categoryId=DOGS"/>"><img src="../images/dogs/dogs_banner3.png" title="DOGS"/></a></div>
					<div><a href="<c:url value="/shop/viewCategory.do?categoryId=CATS"/>"><img src="../images/cats/cats_banner2.png" title="CATS"/></a></div>
					<div><a href="<c:url value="/shop/viewCategory.do?categoryId=REPTILES"/>"><img src="../images/reptiles/reptiles_banner3.png" title="REPTILES"/></a></div>
					<div><a href="<c:url value="/shop/viewCategory.do?categoryId=BIRDS"/>"><img src="../images/birds/birds_banner2.png" title="BIRDS"/></a></div>
		    </div> 
          </td>
          <td width="300px">&nbsp;</td>
          </tr>
    </table>
   </td>
  </tr>
</table><br/><br/>
<%@ include file="IncludeQuickHeader.jsp" %><br/>

<table>
<tr><td width="230px">

		</td><td colspan="4"><b><font color="red" size="20">hit!!</font></b></td><td></tr>
	<tr>
		<td width="230px">

		</td>
		<td width="220px">
			<div class="sliderItem4">
				<!--<c:forEach var="ad" items="${firstAdList}">-->
					<div><a href="<c:url value="/shop/viewItem.do?itemId=aa"/>"><img src="../images/ad_images/bird1.png" title="aa"/></a></div>
				<!--</c:forEach>-->
			</div>
		</td>
		<td width="220px">
			<div class="sliderItem1">
				<c:forEach var="ad" items="${firstAdList}">
					<div><a href="<c:url value="/shop/viewItem.do?itemId=${ ad.itemid }"/>"><img src="../images/ad_images/${ ad.image }" title="${ ad.title }"/></a></div>
				</c:forEach>
			</div>
		</td>
		<td width="220px">
			<div class="sliderItem2">
				<c:forEach var="ad" items="${firstAdList}">
					<div><a href="<c:url value="/shop/viewItem.do?itemId=${ ad.itemid }"/>"><img src="../images/ad_images/${ ad.image }" title="${ ad.title }"/></a></div>
				</c:forEach>
			</div>

		</td>
		<td width="220px">
			<div class="sliderItem3">
				<c:forEach var="ad" items="${firstAdList}">
					<div><a href="<c:url value="/shop/viewItem.do?itemId=${ ad.itemid }"/>"><img src="../images/ad_images/${ ad.image }" title="${ ad.title }"/></a></div>
				</c:forEach>
			</div>
		</td>
 
		<td style="width:500px" rowspan="2">
		
<!-- 광고 바로 이동 구현 -->
			<div class="slider">
				<c:forEach var="ad" items="${firstAdList}">
					<div><a href="<c:url value="/shop/viewItem.do?itemId=${ ad.itemid }"/>"><img src="../images/ad_images/${ ad.image }" title="${ ad.title }"/></a></div>
				</c:forEach>
			</div>
			<div class="slider2">
				<c:forEach var="ad2" items="${secondAdList}">
					<div><a href="<c:url value="/shop/viewItem.do?itemId=${ ad2.itemid }"/>"><img src="../images/ad_images/${ ad2.image }" title="${ ad2.title }"/></a></div>
				</c:forEach>
			</div>
		</td>
		    
	</tr>
	<tr>
		<td width="230px">

		</td>
		<td width="220px">
			<div class="sliderItem4">
				<c:forEach var="ad" items="${firstAdList}">
					<div><a href="<c:url value="/shop/viewItem.do?itemId=${ ad.itemid }"/>"><img src="../images/ad_images/${ ad.image }" title="${ ad.title }"/></a></div>
				</c:forEach>
			</div>
		</td>
		<td width="220px">
			<div class="sliderItem1">
				<c:forEach var="ad" items="${firstAdList}">
					<div><a href="<c:url value="/shop/viewItem.do?itemId=${ ad.itemid }"/>"><img src="../images/ad_images/${ ad.image }" title="${ ad.title }"/></a></div>
				</c:forEach>
			</div>
		</td>
		<td width="220px">
			<div class="sliderItem2">
				<c:forEach var="ad" items="${firstAdList}">
					<div><a href="<c:url value="/shop/viewItem.do?itemId=${ ad.itemid }"/>"><img src="../images/ad_images/${ ad.image }" title="${ ad.title }"/></a></div>
				</c:forEach>
			</div>

		</td>
		<td width="220px">
			<div class="sliderItem3">
				<c:forEach var="ad" items="${firstAdList}">
					<div><a href="<c:url value="/shop/viewItem.do?itemId=${ ad.itemid }"/>"><img src="../images/ad_images/${ ad.image }" title="${ ad.title }"/></a></div>
				</c:forEach>
			</div>
		</td>
	
	</tr>
</table>