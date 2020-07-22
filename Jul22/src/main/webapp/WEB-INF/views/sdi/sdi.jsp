<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<br><br><br>
	${d.name }, ${d.age} <hr>
	${m.name }, ${m.price }<hr>
	${dd.name }, ${dd.age }<hr>
	${h1.name }, ${h1.age }<hr>
	<c:forEach var="n" items="${h1.nickname }">
		${n }
	</c:forEach><br>
	<c:forEach var="f" items="${h1.family }">
		${f }
	</c:forEach><br>
	${h1.score['국어'] }, ${h1.score['영어'] }, ${h1.score['수학'] }<br>
	${h1.pet.name }, ${h1.pet.age }<br>
	
	${h2.name }, ${h2.age }<hr>
	<c:forEach var="n" items="${h2.nickname }">
		${n }
	</c:forEach><br>
	<c:forEach var="f" items="${h2.family }">
		${f }
	</c:forEach><br>
	${h2.score['국어'] }, ${h2.score['영어'] }<br>
	${h2.pet.name }, ${h2.pet.age }<hr>
	
	${h1.maknae.name }, ${h1.maknae.age }	
	
</body>
</html>