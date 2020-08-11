<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="f" items="${files }">
		<table class="anImg">
			<tr>
				<td align="center"><a href="resources/img/${f.dg_file }"><img
						src="resources/img/${f.dg_file }"></a></td>
			</tr>
			<tr>
				<td class="afTitle" align="center">${f.dg_title }</td>
			</tr>
			<tr>
				<c:choose>
					<c:when test="${f.dg_owner == sessionScope.loginMember.dm_id }">
						<td align="right"
							onclick="galleryDelete(${f.dg_no}, '${f.dg_file }');"
							class="afOwner" style="cursor: pointer;">${f.dg_owner }&nbsp;</td>
					</c:when>
					<c:otherwise>
						<td align="right" class="afOwner">${f.dg_owner }&nbsp;</td>
					</c:otherwise>
				</c:choose>
			</tr>
		</table>
	</c:forEach>
	<div style="height: 100px;">&nbsp;</div>
	<!-- ----------------------------------------- -->
	<c:if test="${sessionScope.loginMember != null }">
		<table id="snsWriteArea2">
			<tr>
				<td align="center">
					<form action="gallery.upload" method="post"
						enctype="multipart/form-data" name="gUploadForm"
						onsubmit="return gUploadCheck();">
						<input type="hidden" name="token" value="${token }">
						<table id="snsWriteTable"
							style="color: white; font-family: 'c'; font-size: 15pt;">
							<tr>
								<td id="swtTd1"><input name="dg_title" placeholder="제목"
									maxlength="25" autocomplete="off" id="dutInput"> <input
									name="dg_file" type="file"
									style="font-family: 'c'; font-size: 14pt;"></td>
								<td id="swtTd2"><input type="image"
									src="resources/img/write.png" style="width: 30px;"></td>
							</tr>
						</table>
					</form>
				</td>
				<td id="snsWriteAreaSummoner2" align="center" rowspan="2"
					style="cursor: pointer; background-color: #F44336; border-radius: 0px 20px 20px 0px;"><img
					src="resources/img/menu.png"></td>
			</tr>
		</table>
	</c:if>
</body>
</html>