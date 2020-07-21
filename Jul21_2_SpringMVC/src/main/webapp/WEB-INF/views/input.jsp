<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="resources/css/NewFile.css">
<script type="text/javascript"
	src="resources/js/validCheck.js"></script>
<script type="text/javascript"
	src="resources/js/jul21Check.js"></script>
</head>
<body>
	<h1>인풋페이지</h1>
	<form action="item.purchase"
			name="inputForm"
			onsubmit="return check();"
			autocomplete="off">
		단가<input name="p"><p>
		수량<input name="c"><p>
		<button>계산</button>
		<!-- 계산버튼 누르면 calculateHaha로 Get방식요청 -->
	</form>
	
</body>
</html>