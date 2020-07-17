<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function goSecondC() {
		location.href = "SecondController?a=ㅋ";
	}

	// 1. <a>태그
	//	?요청파라메터명=값
	//	{param.요청파라메터명} = 값
	//	2. <form action="secondC">
	//	<input name="파라메터명">, input에 입력한거 파라메터값
	//	<button>Second로 GET방식요청</button>
	//	</form>
	//	3. JavaScript로  함수, onclick
	//	?요청파라메터명=값
	//	{param.요청파라메터명} = 값
</script>
</head>
<body>
	${sessionScope.c }
	<hr>
	${cookie.d.value }
	<h1>firstView</h1>
	<p>
	<h2 onclick="goSecondC();">SecondC로 GET방식요청</h2>

	<a href="SecondController?a=ㅋ">secondC로 GET방식 요청</a>
	<p>
	<form action="SecondController">
		<input name="a">
		<button>secondC로 GET방식요청</button>
		<p>
	</form>
</body>
</html>