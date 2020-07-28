<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<table id="snsWriteArea" style="bottom:0px;">
		<tr>
			<td align="center">
				<form action="sns.write" name="snsWriteForm" onsubmit="return snsWriteCheck();">
					<table id="snsWriteTable">
						<tr>
							<td id="swtTd1"><textarea name="ds_txt" placeholder="뭐"
									maxlength="250"></textarea></td>
							<td id="swtTd2"><button>쓰기</button></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>






	<table class="sm" style="box-shadow: 5px 5px 5px #F44336;">
		<tr>
			<td rowspan="4" align="center" valign="top" style="width: 95px;">
				<img class="smPhoto" src="resources/img/sns.png"
				style="box-shadow: 3px 3px 3px #F44336;">
			</td>
			<td class="smOwner" style="color: #F44336;">kwon</td>
		</tr>
		<tr>
			<td class="smDate" align="right">20200728</td>
		</tr>
		<tr>
			<td class="smTxt">ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<button style="color: #F44336;">수정</button>
				<button style="color: #F44336;">삭제</button>
			</td>
		</tr>
	</table>

	<table class="sm" style="box-shadow: 5px 5px 5px #43A047;">
		<tr>
			<td rowspan="4" align="center" valign="top" style="width: 95px;">
				<img class="smPhoto" src="resources/img/punch.gif"
				style="box-shadow: 3px 3px 3px #43A047;">
			</td>
			<td class="smOwner" style="color: #43A047;">kwon</td>
		</tr>
		<tr>
			<td class="smDate" align="right">20200728</td>
		</tr>
		<tr>
			<td class="smTxt">ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<button style="color: #43A047;">수정</button>
				<button style="color: #43A047;">삭제</button>
			</td>
		</tr>
	</table>

	<table class="sm" style="box-shadow: 5px 5px 5px #FF9800;">
		<tr>
			<td rowspan="4" align="center" valign="top" style="width: 95px;">
				<img class="smPhoto" src="resources/img/punch.gif"
				style="box-shadow: 3px 3px 3px #FF9800;">
			</td>
			<td class="smOwner" style="color: #FF9800;">kwon</td>
		</tr>
		<tr>
			<td class="smDate" align="right">20200728</td>
		</tr>
		<tr>
			<td class="smTxt">ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<button style="color: #FF9800;">수정</button>
				<button style="color: #FF9800;">삭제</button>
			</td>
		</tr>
	</table>

	<table class="sm" style="box-shadow: 5px 5px 5px #795548;">
		<tr>
			<td rowspan="4" align="center" valign="top" style="width: 95px;">
				<img class="smPhoto" src="resources/img/punch.gif"
				style="box-shadow: 3px 3px 3px #795548;">
			</td>
			<td class="smOwner" style="color: #795548;">kwon</td>
		</tr>
		<tr>
			<td class="smDate" align="right">20200728</td>
		</tr>
		<tr>
			<td class="smTxt">ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<button style="color: #795548;">수정</button>
				<button style="color: #795548;">삭제</button>
			</td>
		</tr>
	</table>

	<table class="sm" style="box-shadow: 5px 5px 5px #E91E63;">
		<tr>
			<td rowspan="4" align="center" valign="top" style="width: 95px;">
				<img class="smPhoto" src="resources/img/punch.gif"
				style="box-shadow: 3px 3px 3px #E91E63;">
			</td>
			<td class="smOwner" style="color: #E91E63;">kwon</td>
		</tr>
		<tr>
			<td class="smDate" align="right">20200728</td>
		</tr>
		<tr>
			<td class="smTxt">ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<button style="color: #E91E63;">수정</button>
				<button style="color: #E91E63;">삭제</button>
			</td>
		</tr>
	</table>

	<table class="sm" style="box-shadow: 5px 5px 5px #009688;">
		<tr>
			<td rowspan="4" align="center" valign="top" style="width: 95px;">
				<img class="smPhoto" src="resources/img/punch.gif"
				style="box-shadow: 3px 3px 3px #009688;">
			</td>
			<td class="smOwner" style="color: #009688;">kwon</td>
		</tr>
		<tr>
			<td class="smDate" align="right">20200728</td>
		</tr>
		<tr>
			<td class="smTxt">ㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋㅋ</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<button style="color: #009688;">수정</button>
				<button style="color: #009688;">삭제</button>
			</td>
		</tr>
	</table>
</body>
</html>