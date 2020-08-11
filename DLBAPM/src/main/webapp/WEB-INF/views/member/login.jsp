<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>딥 러닝 기반의 인공지능 예측분석 전문가 양성과정 카페</title>
</head>
<body>
		<table id="loginTbl">
	<form action="member.login" method="post" name="loginForm" onsubmit="return loginCheck();">
			<tr>
				<td><input name="dm_id" placeholder="ID" maxlength="10" autocomplete="off"></td>
				<td><input name="dm_pw" placeholder="PW" maxlength="10" type="password" autocomplete="off"></td>
				<td><button>Login</button></td>
	</form>
				<td><button onclick="joinGo();">Join</button></td>
			</tr>
		</table>
</body>
</html>


