<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- https://canvasjs.com/javascript-charts/chart-index-data-label/ -->
<!-- 사용법은 https://canvasjs.com/docs/charts/basics-of-creating-html5-chart/title/ -->
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<!-- https://bxslider.com/install/ bxslider 사이트에서, jquery는 있을땐 생략해도 -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>
<script type="text/javascript">
/// 미세먼지 날씨 데이터 그래프 시각화, 검색API 결과=>슬라이드 넘기기 
	$(function(){
		$("#b1").click(function(){
			var i1ValHaha = $("#i1").val();
			$.ajax({
				url : "air.get",
				data : {when : i1ValHaha},
				success : function(airXmlDataHaha){
					// Xml 받아오는데 성공하면
					var ar = [];
					
					$(airXmlDataHaha).find("row").each(function(i, a){
						ar[i] = {
									label: $(a).find("MSRSTE_NM").text(),
									y : $(a).find("PM10").text()*1 // Js글자를 숫자로 바꾼것
								};
						// var pm25 = $(a).find("PM25").text();
					}); 
					
					
					var chart = new CanvasJS.Chart("chartContainer", {
						animationEnabled: true,
						exportEnabled: true,
						theme: "dark1", // "light1", "light2", "dark1", "dark2"
						title:{
							text: "Check PM2.5 Data"
						},
					  	axisY: {
					      includeZero: true
					    },
						data: [{
							type: "column", //change type to bar, line, area, pie, etc
							//indexLabel: "{y}", //Shows y value on all Data Points
							indexLabelFontColor: "#5A5757",
					      	indexLabelFontSize: 16,
							indexLabelPlacement: "outside",
							dataPoints: ar
						}]
					});
					chart.render();
				}
			});
		});
		
		$("#i1").keyup(function(){
			$("#b1").trigger("click");
		});
		//////////weatherxml////////////////////////////////////////////////////////
		$("#b2").click(function(){
			$.ajax({
				url : "weather.get",
				success : function(weatherXmlDataHaha){
					// Xml 받아오는데 성공하면
					var ar2 = [];
					
					$(weatherXmlDataHaha).find("data").each(function(i2, w){
						ar2[i2] = {
									label : $(w).find("hour").text() + "시",
									y : $(w).find("temp").text()*1 // Js글자를 숫자로 바꾼것
								};
						// var pm25 = $(a).find("PM25").text();
					}); 
					
					
					var chart = new CanvasJS.Chart("chartContainer2", {
						animationEnabled: true,
						exportEnabled: true,
						theme: "dark1", // "light1", "light2", "dark1", "dark2"
						title:{
							text: "Weather"
						},
					  	axisY: {
					      includeZero: true
					    },
						data: [{
							type: "line", //change type to bar, line, area, pie, etc
							//indexLabel: "{y}", //Shows y value on all Data Points
							indexLabelFontColor: "#5A5757",
					      	indexLabelFontSize: 16,
							indexLabelPlacement: "outside",
							dataPoints: ar2
						}]
					});
					chart.render();
				}
			});
		});
		
		$("#b2").trigger("click");
		////bxslider//////////////////////////////////////////////////////////////
		var bs = $('.bxslider').bxSlider({
		    mode: 'horizontal',
		    captions: true,
		    slideWidth: 600,
		    speed: 1000,
		    auto:true
		});
		//////////////////////////////////////////////////////////////////
		$("#b3").click(function(){
			var i3Val = $("#i3").val();
			$.ajax({
				url : "https://dapi.kakao.com/v3/search/book",
				data : {query : i3Val},
				beforeSend : function(req){
					req.setRequestHeader("Authorization","KakaoAK 80b818832ce2303ea5f03b9758428f1b"); // 헤더 제목, 키값(KakaoAK REST API키)
				},
				success : function(bookssss){
					$(".bxslider").empty();
					var ar = bookssss.documents;
					$.each(ar,function(i,b){
						var imgTag = $("<img>").attr("src",b.thumbnail)
							.attr("title",b.title + ":" + b.authors[0]);
						var divTag = $("<div></div>").append(imgTag);
						$(".bxslider").append(divTag);
						
						/* alert(b.title);
						alert(b.price);
						alert(b.authors[0]);
						alert(b.thumbnail); */
					});
					bs.reloadSlider();
				}
				
				
				
			});
		});
		$("#i3").keyup(function(){
			$("#b3").trigger("click");
		});
		
	});
	// AJAX : 외부 데이터를 가져오지 못함
	// Cross-Domain AJAX
	//		1) Proxy(우회) (안될때)
	//		2) 서버측에서 데이터를 남에게 제공하려면
	//			응답헤더에 세팅(HttpServletResponse res)
	//				res.setHeader("Access-Control-Allow-Origin", "*")
</script>
</head>
<body>
	<input id="i3"> <button id="b3">검색</button>
	<input id="i1"> <button id="b1">미세먼지확인</button>
	<button id="b2">날씨확인</button>
	<div id="chartContainer" style="height: 370px; width: 100%;"></div>
	<div id="chartContainer2" style="height: 370px; width: 100%;"></div>
	<br>
	<div class="bxslider">
  		<!-- <div><video></video></div>  비디오도 가능-->
  		<div><img src="resources/img/gogeta.gif" title="aa"></div>
  		<div><img src="resources/img/gohan.gif" title="aa"></div>
  		<div><img src="resources/img/ssj4_goku.gif" title="aa"></div>
  		<div><img src="resources/img/pa.gif" title="파"></div>
  		<div><img src="resources/img/vegeta.gif" title="베지타"></div>
	</div>
	
</body>
</html>