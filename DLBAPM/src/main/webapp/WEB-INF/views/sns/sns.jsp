<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<c:if test="${curPage !=1 }">
	<table id="snsL">
		<tr>
			<td align="center" onmouseleave="snsPageChange(${curPage - 1 });">&lt;</td>
		</tr>
	</table>
	</c:if>
	<c:if test="${curPage != allPageCount }">
	<table id="snsR">
		<tr>
			<td align="center" onmouseleave="snsPageChange(${curPage + 1 });">&gt;</td>
		</tr>
	</table>
	</c:if>
	
	<table id="snsWriteArea" style="left: 0px;">
		<tr>
			<td>
				<form action="sns.search" name="snsSearchForm"
					onsubmit="return snsSearchCheck();"
					method="post">
					<table id="snsSearchTable">
						<tr>
							<td id="sstTd1">
								<input name="search" maxlength="10"
								autocomplete="off" placeholder="search"></td>
							<td id="sstTd2">
								<input type="image"
								src="resources/img/search.png" style="width: 30px;"></td>
						</tr>
					</table>
				</form>
			</td>
			<td id="snsWriteAreaSummoner" align="center" rowspan="2" style="background-color: #F44336; border-radius:0px 20px 20px 0px;"><img src="resources/img/menu.png"
				style="cursor: pointer;"></td>
		</tr>
		<tr>
			<td align="center">
				<form action="sns.write" name="snsWriteForm"
					onsubmit="return snsWriteCheck();" method="post">
					<input name="token" value="${token }" type="hidden">
					<table id="snsWriteTable">
						<tr>
							<td id="swtTd1"><textarea name="ds_txt" placeholder="InputMsg"
									maxlength="250"></textarea></td>
							<td id="swtTd2"><input type="image"
								src="resources/img/write.png" style="width: 30px;"></td>
						</tr>
					</table>
				</form>
			</td>
		</tr>
	</table>
	
	<c:forEach var="sm" items="${msgs }" >
	
	<table class="sm" style="box-shadow: 5px 5px 5px ${sm.ds_color};">
		<tr>
			<td rowspan="4" align="center" valign="top" style="width: 95px;">
				<img class="smPhoto" src="resources/img/${sm.dm_photo }"
				style="box-shadow: 3px 3px 3px ${sm.ds_color};">
			</td>
			<td class="smOwner" style="color: ${sm.ds_color};">${sm.dm_id }</td>
		</tr>
		<tr>
			<td class="smDate" align="right"><fmt:formatDate
						value="${sm.ds_when }" type="both" dateStyle="long" timeStyle="short" /></td>
		</tr>
		<tr>
			<td class="smTxt">${sm.ds_txt }</td>
		</tr>
		<tr>
			<td id="smReplyArea">
				<c:forEach var="sr" items="${sm.reply }">
						<span class="smReplyID" style="color:${sm.ds_color}">${sr.dsr_owner }</span> ${sr.dsr_txt }(<fmt:formatDate value="${sr.dsr_when }" type="both" dateStyle="short" timeStyle="short"/>)<br>
					</c:forEach>
				
				<hr color="${sm.ds_color}">
					<form action="sns.reply.write" method="post"
						onsubmit="return snsWriteReplyCheck(this);">	
						<input name="token" value="${token }" type="hidden">
						<input name="dsr_ds_no" value="${sm.ds_no }" type="hidden">
						<span class="smReplyID" style="color:${sm.ds_color}">kwon</span>
						<input name="dsr_txt" style="border-bottom:${sm.ds_color} solid 2px;" maxlength="100" placeholder="댓">
						<button style="color:${sm.ds_color}">쓰기</button>
					</form>
			</td>
		</tr>
		<tr>
			<td>&nbsp;</td>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<c:if test="${sm.dm_id == sessionScope.loginMember.dm_id }">
				<button onclick="snsMsgUpdate(${sm.ds_no}, '${sm.ds_txt }');" style="color: ${sm.ds_color};">Update</button>
				<button onclick="snsMsgDelete(${sm.ds_no});" style="color: ${sm.ds_color};">Remove</button>
				</c:if>
			</td>
		</tr>
	</table>
	</c:forEach>
</body>
</html>