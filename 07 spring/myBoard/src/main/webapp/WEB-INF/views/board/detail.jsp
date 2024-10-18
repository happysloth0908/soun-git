<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글 디테일</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<tr>
			<th>${board.no}</th>
			<th>${board.title}</th>
			<th>${board.writer}</th>
			<th>${board.viewCnt}</th>
			<th>${board.regDate}</th>
		</tr>
		<a href="${pageContext.request.contextPath}/upload/${filePath}/${fileName}">"${pageContext.request.contextPath}/upload/${filePath}/${fileName}"</a>
		<img src="${pageContext.request.contextPath}/upload/${filePath}/${fileName}">
	</table>
</body>
</html>