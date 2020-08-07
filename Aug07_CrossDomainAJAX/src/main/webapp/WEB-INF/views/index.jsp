<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
// https://openweathermap.org/current#geo
//	브라우저 위도 경도값 받아서 그곳의 날씨 웹에 표시 
	$(function(){
		// HTML5주제에 클라이언트의 현재 위치를 받을 수 있음
		// 클라이언트에게 GPS가 있으면 GPS로 받음
		// 클라이언트에게 GPS가 없으면 IP주소로 받음(정확도 떨어짐)
		
		// 학원이 59.9.140.27을 사 왔음
		// 59.9.140.27을 여러명이 사용가능하게 : 공유기
		navigator.geolocation.getCurrentPosition(function(where){
			// coordinate 위도경도시스템
			var lat = where.coords.latitude; //클라이언트의 현재위치 위도값
			var lng = where.coords.longitude; // 클라이언트의 현재위치 경도값
			$("body").append(lat + "," + lng);
		 // 클라이언트의 현재 위치 받기
		
		// JSON데이터는 원하는 값 마우스 갖다대면 밑에 그 값의 위치가 나옴
		$.getJSON("http://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lng + "&appid=baff8f3c6cbc28a4024e336599de28c4&units=metric",
				function(weatherDataHaha){
					$("h1").text(weatherDataHaha.name);
					$("h2").text(weatherDataHaha.weather[0].description);
					$("h3").text(weatherDataHaha.main.temp);
					$("img").attr("src",
							"https://openweathermap.org/img/wn/"+
							weatherDataHaha.weather[0].icon
							+"@2x.png");
				});
		});
	});
</script>
</head>
<body style="background-color: black; color: white;">
	<img><h1></h1><h2></h2><h3></h3>
</body>
</html>