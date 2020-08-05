<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	function menuParse(dataHaha){
		$("#t1").empty();
		$(dataHaha).find("menu").each(function(i, m){ // jQuery반복문 1234의 i, 객체의 n
			var name = $(m).find("m_name").text();
			var price = $(m).find("m_price").text();
			
			var nTd = $("<td></td>").text(name);
			var pTd = $("<td></td>").text(price);
			var tr = $("<tr></tr>").append(nTd, pTd);
			$("#t1").append(tr);
		});
	}
	
	$(function(){
		$.ajax({
			url : "menu.get2", // 전체조회
			success : function(dsa){ // dsa : 가져온 XML데이터
				menuParse(dsa);
			}
		});
		////////////////////////////////
		$("button").click(function(){
			var iVal = $("input").val();
			
			$.ajax({
				url : "menu.search", 	// 요청주소, 검색
				data : {m_name:iVal}, 	// 요청파라메터
				success : function(xmlDataHaha){ // 데이터 받는데 성공하면 함수가 자동호출
					// alert(xmlDataHaha);
					menuParse(xmlDataHaha);
				}
				
			});
		});
		
		
		//////////////////////
		$("input").keyup(function(e){
			//if (e.keyCode == 13) { //엔터키에서 손 뗄 때 , if문을 비활성화 시키면 실시간 검색
				// 강제 이벤트 발생 시키기
				$("button").trigger("click");
			//}
		});
	});
</script>



</head>
<body>
	<input><button>검색</button>
	<hr>
	
	<table id="t1" border="1">
		<tr>
			<th>메뉴명</th>
			<th>가격</th>
		</tr>
		
	</table>
</body>
</html>