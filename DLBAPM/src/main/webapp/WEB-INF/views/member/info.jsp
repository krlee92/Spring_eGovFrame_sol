<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
		<table id="joinTbl">
	<form action="member.update"
		method="post"
		enctype="multipart/form-data" 
		name="memberUpdateForm" onsubmit="return memberUpdateCheck();">
			<tr>
				<th><input name="dm_id" value="${sessionScope.loginMember.dm_id }" class="width100" readonly="readonly" style="text-align: center; font-size: 20pt; color:white;"></th>
			</tr>
			<tr>
				<td>
					<input name="dm_pw" value="${sessionScope.loginMember.dm_pw }" class="width100" type="password" placeholder="PW" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					<input name="dm_pwChk" value="${sessionScope.loginMember.dm_pw }" class="width100" type="password" placeholder="PW확인" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					<input name="dm_name" value="${sessionScope.loginMember.dm_name }" class="width100" placeholder="이름" maxlength="10" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					<input name="dm_addr1" value="${addr[2] }" style="width:550px;" placeholder="우편번호" maxlength="5" autocomplete="off">
					<span id="addrSearchBtn">[주소검색]</span>
				</td>
			</tr>
			<tr>
				<td>
					<input name="dm_addr2" value="${addr[0] }" class="width100" placeholder="주소" maxlength="170" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td>
					<input name="dm_addr3" value="${addr[1] }" class="width100" placeholder="상세주소" maxlength="30" autocomplete="off">
				</td>
			</tr>
			<tr>
				<td style="font-family:'c';font-size: 17pt; padding-left: 10px; padding-top:13px; font-weight: 900;">
					<img src="resources/img/${sessionScope.loginMember.dm_photo }" style="max-width: 30%; box-shadow: 3px 3px 3px black;">
					<input name="dm_photo" type="file" autocomplete="off">
				</td>
			</tr>
			<tr>
				<th style="padding-top: 10px;padding-bottom: 10px;">
					<button style="width:45%;">수정</button>&nbsp;
	</form>
					<button onclick="bye();" style="width:45%;">탈퇴</button>
				</th>
			</tr>
		</table>
</body>
</html>