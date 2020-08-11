<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="member.join"
		method="post"
		enctype="multipart/form-data" 
		name="joinForm" onsubmit="return joinCheck();">
		<table id="joinTbl">
			<tr>
				<th>회원가입</th>
			</tr>
			<tr>
				<td>
					<input name="dm_id" class="width100" placeholder="ID" maxlength="10" autocomplete="off" autofocus="autofocus">
				</td>
			</tr>
			<tr>
				<td>
					<input name="dm_pw" class="width100" type="password" placeholder="PW" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					<input name="dm_pwChk" class="width100" type="password" placeholder="PW확인" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					<input name="dm_name" class="width100" placeholder="이름" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					<input name="dm_addr1" style="width:550px;" placeholder="우편번호" maxlength="5" autocomplete="off">
					<span id="addrSearchBtn">[주소검색]</span>
				</td>
			</tr>
			<tr>
				<td>
					<input name="dm_addr2" class="width100" placeholder="주소" maxlength="170" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					<input name="dm_addr3" class="width100" placeholder="상세주소" maxlength="30" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td style="font-family:'c';font-size: 17pt; padding-left: 10px; font-weight: 900;">
					사진&nbsp;&nbsp;<input name="dm_photo" type="file" style="margin-top: 13px;"autocomplete="off">
				</td>
			</tr>
			<tr>
				<th style="padding-top: 10px;padding-bottom: 10px;">
					<button>가입</button>
				</th>
			</tr>
		</table>
	</form>
</body>
</html>