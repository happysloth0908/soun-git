<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
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
			<th>내용</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<tr>
			<th>${board.no}</th>
			<th>${board.title}</th>
			<th>${board.writer}</th>
			<th>${board.content}</th>
			<th>${board.viewCnt}</th>
			<th>${board.regDate}</th>
		</tr>
		<c:if test="${not empty filePath}">
		<a href="${pageContext.request.contextPath}/upload/${filePath}/${fileName}">${fileName}</a>
		<img src="${pageContext.request.contextPath}/upload/${filePath}/${fileName}">
		</c:if>
		
		<a href="/board/updateform?no=${board.no}">수정하기</a>
		<a href="/board/delete?no=${board.no}">삭제하기</a>
		<a href="/board/list">목록가기</a>
	</table>
</body>
</html>