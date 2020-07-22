<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jul22</title>
<link rel="stylesheet" href="resources/css/index.css">
</head>
<body>
	<table id="siteTitleArea">
		<tr>
			<td id="siteTitle">
				<a href="index.do">Jul22</a>
			</td>
		</tr>
		<tr>
			<td id="siteMenuArea">
				<a href="calc.go">사칙연산</a>
				<a href="sdi.go">Spring DI & IoC</a>
				<a href="count.go">돈계산</a>
				<a href="">?</a>
			</td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<td align="center">
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>








