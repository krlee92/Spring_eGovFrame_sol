<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>딥 러닝 기반의 인공지능 예측분석 전문가 양성과정 카페</title>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/member.css">
<link rel="stylesheet" href="resources/css/sns.css">
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/dlbapmCheck.js"></script>
</head>
<body onload="imgBlink();">
	<table id="siteTitleArea">
		<tr>
			<td align="center">
				<table id="siteMenuArea">
					<tr>
						<td><jsp:include page="${loginPage }"></jsp:include></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td align="center">
				<table id="siteTitleArea2">
					<tr>
						<td valign="bottom" style="width: 50px;"><img id="titleImg"
							src="resources/img/c727.jpg"> <img id="titleImg2"
							src="resources/img/c7272.jpg"></td>
						<td><a href="index.do"><span>딥 러닝</span> 기반의 <span>인공지능</span>
								예측분석 전문가 양성과정 카페 <span
								style="font-family: 'b'; font-size: 15pt; color: #F44336;">v1.0</span></a></td>
						<td align="right" valign="bottom"
							style="color: #FFCC80; font-size: 12pt; font-family: 'b';">${r }</td>
					</tr>
					<tr>
						<td align="right" id="siteAddr" colspan="3">http://192.168.0.81/dlbapm이지만 곧 http://cjsckddnjs.cafe24.com로 옮길 예정</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<table id="siteContentArea">
		<tr>
			<td align="center"><jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>