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
	<table id="drArea">
		<tr>
			<td align="center" style="background-color: #F44336;"><img
				src="resources/img/book.png"></td>
			<td align="center" style="background-color: #43A047;"><img
				src="resources/img/code.png"></td>
			<td align="center" style="background-color: #039BE5;"><img
				src="resources/img/apps.png"></td>
			<td align="center" style="background-color: #795548;"><img
				src="resources/img/attachment.png"></td>
		</tr>
		<tr>
			<td style="height: 650px;" align="center" valign="top">
				<div id="drBookArea">
					<c:forEach var="f" items="${book }">
						<table class="aData" style="background-color: #F44336;">
							<tr>
								<td colspan="2" align="center" class="adTitle">${f.dd_title }</td>
							</tr>
							<tr>
								<td align="center" class="adImgTd" rowspan="2"><a
									href="resources/drFile/${f.dd_file }"> <img
										src="resources/img/${f.dd_cate }.png">
								</a></td>
								<c:choose>
									<c:when test="${f.dd_owner == sessionScope.loginMember.dm_id }">
										<td align="right" ondblclick="drDelete(${f.dd_no});"
											style="padding-right: 7px; font-size: 13pt; font-weight: 900; width: 60%; cursor: pointer;"
											valign="bottom">${f.dd_owner }</td>
									</c:when>
									<c:otherwise>
										<td align="right"
											style="padding-right: 7px; font-size: 13pt; font-weight: 900; width: 60%;"
											valign="bottom">${f.dd_owner }</td>
									</c:otherwise>
								</c:choose>
							</tr>
							<tr>
								<td align="right"
									style="padding-right: 7px; font-size: 13pt; font-weight: 900;">
									<fmt:formatDate value="${f.dd_when }" type="date"
										dateStyle="short" />
								</td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</td>
			<td style="height: 650px;" align="center" valign="top">
				<div id="drCodeArea">
					<c:forEach var="f" items="${code }">
						<table class="aData" style="background-color: #43A047;">
							<tr>
								<td colspan="2" align="center" class="adTitle">${f.dd_title }</td>
							</tr>
							<tr>
								<td align="center" class="adImgTd" rowspan="2"><a
									href="resources/drFile/${f.dd_file }"> <img
										src="resources/img/${f.dd_cate }.png">
								</a></td>
								<c:choose>
									<c:when test="${f.dd_owner == sessionScope.loginMember.dm_id }">
										<td align="right" ondblclick="drDelete(${f.dd_no});"
											style="padding-right: 7px; font-size: 13pt; font-weight: 900; width: 60%; cursor: pointer;"
											valign="bottom">${f.dd_owner }</td>
									</c:when>
									<c:otherwise>
										<td align="right"
											style="padding-right: 7px; font-size: 13pt; font-weight: 900; width: 60%;"
											valign="bottom">${f.dd_owner }</td>
									</c:otherwise>
								</c:choose>
							</tr>
							<tr>
								<td align="right"
									style="padding-right: 7px; font-size: 13pt; font-weight: 900;">
									<fmt:formatDate value="${f.dd_when }" type="date"
										dateStyle="short" />
								</td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</td>
			<td style="height: 650px;" align="center" valign="top">
				<div id="drAppsArea">
					<c:forEach var="f" items="${apps }">
						<table class="aData" style="background-color: #039BE5;">
							<tr>
								<td colspan="2" align="center" class="adTitle">${f.dd_title }</td>
							</tr>
							<tr>
								<td align="center" class="adImgTd" rowspan="2"><a
									href="resources/drFile/${f.dd_file }"> <img
										src="resources/img/${f.dd_cate }.png">
								</a></td>
								<c:choose>
									<c:when test="${f.dd_owner == sessionScope.loginMember.dm_id }">
										<td align="right" ondblclick="drDelete(${f.dd_no});"
											style="padding-right: 7px; font-size: 13pt; font-weight: 900; width: 60%; cursor: pointer;"
											valign="bottom">${f.dd_owner }</td>
									</c:when>
									<c:otherwise>
										<td align="right"
											style="padding-right: 7px; font-size: 13pt; font-weight: 900; width: 60%;"
											valign="bottom">${f.dd_owner }</td>
									</c:otherwise>
								</c:choose>
							</tr>
							<tr>
								<td align="right"
									style="padding-right: 7px; font-size: 13pt; font-weight: 900;">
									<fmt:formatDate value="${f.dd_when }" type="date"
										dateStyle="short" />
								</td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</td>
			<td style="height: 650px;" align="center" valign="top">
				<div id="drAttachmentArea">
					<c:forEach var="f" items="${attachment }">
						<table class="aData" style="background-color: #795548;">
							<tr>
								<td colspan="2" align="center" class="adTitle">${f.dd_title }</td>
							</tr>
							<tr>
								<td align="center" class="adImgTd" rowspan="2"><a
									href="resources/drFile/${f.dd_file }"> <img
										src="resources/img/${f.dd_cate }.png">
								</a></td>
								<c:choose>
									<c:when test="${f.dd_owner == sessionScope.loginMember.dm_id }">
										<td align="right" ondblclick="drDelete(${f.dd_no});"
											style="padding-right: 7px; font-size: 13pt; font-weight: 900; width: 60%; cursor: pointer;"
											valign="bottom">${f.dd_owner }</td>
									</c:when>
									<c:otherwise>
										<td align="right"
											style="padding-right: 7px; font-size: 13pt; font-weight: 900; width: 60%;"
											valign="bottom">${f.dd_owner }</td>
									</c:otherwise>
								</c:choose>
							</tr>
							<tr>
								<td align="right"
									style="padding-right: 7px; font-size: 13pt; font-weight: 900;">
									<fmt:formatDate value="${f.dd_when }" type="date"
										dateStyle="short" />
								</td>
							</tr>
						</table>
					</c:forEach>
				</div>
			</td>
		</tr>
	</table>

	<table id="snsWriteArea2">
		<tr>
			<td align="center">
				<form action="dataroom.upload" name="drUploadForm"
					onsubmit="return drUploadCheck();" method="post"
					enctype="multipart/form-data">
					<input name="token" value="${token }" type="hidden">
					<table id="snsWriteTable"
						style="color: white; font-family: 'c'; font-size: 15pt;">
						<tr>
							<td id="dutTd1"><input name="dd_title" placeholder="제목"
								id="dutInput" maxlength="25" autocomplete="off"></td>
							<td id="swtTd2" rowspan="3"><input type="image"
								src="resources/img/upload.png" style="width: 30px;"></td>
						</tr>
						<tr>
							<td id="dutTd3"><input type="radio" value="book"
								name="dd_cate" checked="checked">교재&nbsp; <input
								type="radio" value="code" name="dd_cate">예제&nbsp; <input
								type="radio" value="apps" name="dd_cate">프로그램&nbsp; <input
								type="radio" value="attachment" name="dd_cate">기타</td>
						</tr>
						<tr>
							<td id="dutTd4"><input type="file" name="dd_file"
								style="font-family: 'c'; font-size: 14pt;"></td>
						</tr>
					</table>
				</form>
			</td>
			<td id="snsWriteAreaSummoner2" align="center" rowspan="2"
				style="cursor: pointer; background-color: #F44336; border-radius: 0px 20px 20px 0px;"><img
				src="resources/img/menu.png"></td>
		</tr>
	</table>
</body>
</html>