<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<head>
<script src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
   <script src="http://code.highcharts.com/highcharts.js"></script>
</head>
<div id="chart" style="width: 650px; height: 400px; margin: 0 auto"></div>
<script language="JavaScript" charset="UTF-8">

$(document).ready(function() {
	var list = [];
		<c:forEach items = "${bidListChart}" var="item">
			list.push("${item.bid_date}");
		</c:forEach>

	var data = [];
	<c:forEach items = "${bidListChart}" var="item">
		data.push(Number("${item.bid_price}"));
	</c:forEach>
		
		
   var title = {
      text: 'Auction Progress'   
   };
   var subtitle = {
      text: '경매 상황'
   };
    
   /* x축 : 날짜 */
   var xAxis = {
      	 categories: list
   };
   
   /* y축 : 입찰가 */
   var yAxis = {
      title: {
         text: 'PRICE (KRW)'
      },
      plotLines: [{
         value: 0,
         width: 1,
         color: '#808080'
      }]
   };   

   /* y축의 제목 */
   var tooltip = {
      valueSuffix: 'KRW'
   }
   
   /* X축의 범례 */
   var legend = {
      layout: 'vertical',
      align: 'right',
      verticalAlign: 'middle',
      borderWidth: 0
   };
   
	/* 차트 데이터 */
   var series =  [
      {
         name: 'Bid Price',
         data: data
      }
   ];

   var json = {};

   json.title = title;
   json.subtitle = subtitle;
   json.xAxis = xAxis;
   json.yAxis = yAxis;
   json.tooltip = tooltip;
   json.legend = legend;
   json.series = series;

   $('#chart').highcharts(json);
});
</script>
