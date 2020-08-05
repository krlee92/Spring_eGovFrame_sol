<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/jQuery.js"></script>
<script type="text/javascript">
// AJAX(Asynchronous JavaScript And Xml) : 동사, 행위
//		비동기식으로 자바스크립트를 써서 XML파싱
//		내 사이트것만 가능(브라우저의 동일 출처 정책)
//		Cross-Domain AJAX
	$(function(){
		$("#b1").click(function(){
			$.ajax({
				url : "menu.get2",
				success : function(dsa){ // dsa : 가져온 XML데이터
					$("#t1").empty();
					$(dsa).find("menu").each(function(i, m){ // jQuery반복문 1234의 i, 객체의 n
						var name = $(m).find("m_name").text();
						var price = $(m).find("m_price").text();
						
						var nTd = $("<td></td>").text(name);
						var pTd = $("<td></td>").text(price);
						var tr = $("<tr></tr>").append(nTd, pTd);
						$("#t1").append(tr);
					});
				}
			});
		});
		alert("ㅋ"); // 요청 ok가 안나와도 프로그램 진행(ㅋ가 먼저나옴,비동기식이라)
		////////////////////////////////////////////////////////////////////////////
	});
</script>
</head>
<body>
	<button id="b1">메뉴출력</button>
	<table id="t1" border="1">
		<tr>
			<th>메뉴명</th>
			<th>가격</th>
		</tr>
		
	</table>
	
	<hr>
	<c:forEach var="m" items="${menus }">
		${m.m_name } - ${m.m_price }<p>
	</c:forEach>
	<hr>
	<c:forEach var="c" items="${champs }">
		${c.c_name } - ${c.c_skill } - ${c.c_ult }<p>
	</c:forEach>

</body>
</html>