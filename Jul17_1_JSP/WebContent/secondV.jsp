<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function goThirdC(){
	location.href = "ThirdController";
}
</script>
</head>
<body>
 <h1>SecondView</h1>
 ${param.a }<p>
 ${b }<p>
 
 <h2 onclick="goThirdC();">ThirdC로 GET방식요청</h2>
 
</body>
</html>