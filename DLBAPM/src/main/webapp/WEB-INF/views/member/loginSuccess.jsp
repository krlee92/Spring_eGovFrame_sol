<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>딥 러닝 기반의 인공지능 예측분석 전문가 양성과정 카페</title>
</head>
<body>
	<table id="menuTbl">
		<tr>
			<td class="m" align="center"><a href="sns.go"><img
					src="resources/img/sns.png" class="mImg"></a></td>
			<td class="m" align="center"><a href="dataroom.go"><img
					src="resources/img/dataroom.png" class="mImg"></a></td>
			<td class="m" align="center"><a href="gallery.go"><img
					src="resources/img/gallery.png" class="mImg"></a></td>
			<td class="m" align="center"><a href=""><img
					src="resources/img/community.png" class="mImg"></a></td>
			<td align="right">
				<table>
					<tr>
						<td rowspan="2"><img id="loginMemberImg" src="resources/img/${sessionScope.loginMember.dm_photo }"></td>
						<td id="loginMemberID" valign="top" style="width:200px;">${sessionScope.loginMember.dm_id }(${sessionScope.loginMember.dm_name })</td>
					</tr>
					<tr>
						<td valign="bottom" align="right"><button onclick="memberInfoGo();" class="loginMemberBtn">Info</button><button onclick="logout();" class="loginMemberBtn">Logout</button></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>