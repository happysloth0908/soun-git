<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시판 목록</h2>
	<!-- 이 페이지에는 데이터에 있는 모든 보드를 가져와야 함.  -->
	<table>
		<thead>
			<th>글번호</th>
			<th>문제 번호</th>
			<th>문제 이름</th>
			<th>작성자</th>
			<th>작성 시간</th>
			<th>조회수</th>
		</thead>
		<c:forEach var="board" items="${list}">
		<tbody>
			<td> <a href="${contextPath}/board?action=detail&no=${board.no}">(${board.no})</a></td>
			<td>${board.probNo}</td>
			<td>${board.probName}</td>
			<td>${board.writer}</td>
			<td>${board.time}</td>
			<td>${board.viewCnt}</td>
		</tbody>
		</c:forEach>
	</table>
</body>
</html>