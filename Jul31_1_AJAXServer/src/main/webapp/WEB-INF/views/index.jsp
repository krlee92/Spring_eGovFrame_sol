<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
	$(function(){
		/* $.ajax({
			url : "champ.get2",
			success : function(dsa){
				// alert(dsa);
				// JS객체 -> 문자열
				alert( JSON.stringify(dsa) );
				
			}
		}); */ // FM AJAX문법인데
		
		// JSON전용 AJAX 메소드 따로 만들어놨음
		// $.getJSON("요청주소(파라메터 있으면 파라메터도)");
		$.getJSON("champ.get2", function(zxc){
			// var ar = zxc.champ; // JSON 대괄호 champ : 대괄호 -> 대괄호 안에 객체들이..
			$.each(zxc.champ, function(i, c){ // 반복문.ecah(배열,함수명)
				var nTd = $("<td></td>").text(c.c_name);
				var sTd = $("<td></td>").text(c.c_skill);
				var uTd = $("<td></td>").text(c.c_ult);
				var tr = $("<tr></tr>").append(nTd, sTd, uTd);
				$("#t1").append(tr);
			});
		});
		
	});

</script>

</head>
<body>
	<table id="t1" border="1"></table>
</body>
</html>