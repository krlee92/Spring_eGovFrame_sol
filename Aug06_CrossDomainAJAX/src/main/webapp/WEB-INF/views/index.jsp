<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript">
	// AJAX : 외부 데이터를 가져오지 못함
	//			브라우저의 동일 출처 정책
	
	// Cross-Domain AJAX : 남의거를 가져올수 있게
	//		프록시 서버 proxy server를 구현
	//		....
	$(function(){
		$("button").click(function(){
			$.ajax({
				url : "weather.get",
				success : function(asd){
					$(asd).find("data").each(function(i, w){
						alert($(w).find("hour").text());
						alert($(w).find("temp").text());
						alert($(w).find("wfKor").text());
					});
				}
			});
			/* $.ajax({
				// 기상청 API XML 원주소
				// http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=2818585000
				url : "http://www.kma.go.kr/wid/queryDFSRSS.jsp", // JSP까지
				data : {zone : "2818585000"}, // 요청파라메터 처리
				success : function(wxml){
					alert(wxml);
				}
			}); */ // AJAX는 외부 데이터 못가져와서 못씀
			
		});
	});
</script>
</head>
<body>
	<button>날씨확인</button>
</body>
</html>