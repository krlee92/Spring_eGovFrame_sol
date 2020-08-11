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
<link rel="stylesheet" href="resources/css/dataroom.css">
<link rel="stylesheet" href="resources/css/gallery.css">
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script type="text/javascript" src="resources/js/go.js"></script>
<script type="text/javascript" src="resources/js/validCheck.js"></script>
<script type="text/javascript" src="resources/js/dlbapmCheck.js"></script>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/dlbapm_jQuery.js"></script>
<script type="text/javascript">
//navigator.userAgent : 현재 접속한 브라우저 정보

/* 	if(navigator.userAgent.indexOf("Android") != -1 || ){
 location.href = "mobile.index.do";		
 }else if(navigator.userAgent.indexOf("Windows") != -1){
 location.href = "";
 } */
</script>

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
						<td valign="bottom" style="width: 50px;"></td>
						<td><a href="index.do"><span>Spring</span> Project <span>feat.Maven</span>
								Cafe <span
								style="font-family: 'b'; font-size: 15pt; color: #F44336;">v1.0</span></a></td>
						<td align="right" valign="bottom"
							style="color: #FFCC80; font-size: 12pt; font-family: 'b';">${r }</td>
					</tr>
					<tr>
						<td align="right" id="siteAddr" colspan="3">http://soldesk06.cafe24.com</td>
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