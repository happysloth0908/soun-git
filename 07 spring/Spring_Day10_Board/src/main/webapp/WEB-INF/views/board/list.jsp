<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
<%@ include file="../common/bootstrap.jsp" %>
</head>

<body>
	<div class="container">
		<h2>게시글 목록</h2>
<%@ include file="../common/header.jsp" %>
		<hr>
		<%@ include file="../common/searchForm.jsp" %>
		<table class="table text-center">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>조회수</th>
				<th>날짜</th>
			</tr>
			<!-- ????? 왜 아이템이랑 반대지? -->
			<c:forEach items="${boards}" var="board">
			<tr>
				<td>${board.id}</td>
				<td><a href="detail?id=${board.id}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.viewCnt}</td>
				<td>${board.regDate}</td>
			</tr>
			</c:forEach>
		</table>
		<div>
		<c:if test="${prev}">
		<a href="/list?page=1">처음 페이지</a>
		<a href="/list?page=${startPage - 1}">이전</a>
		</c:if>
			<c:forEach var="i" begin="${startPage}" end="${lastPage}">
				<a href="/list?page=${i}">[${i}]</a>
			</c:forEach>
		<a href="/list?page=${lastPage + 1}">다음</a>
		<a href="/list?page=${endPage}">마지막 페이지</a>
		</div>
		<div class="d-flex justify-content-end">
		<a class="btn-outline-primary" href="/writeform">글등록</a>
		</div>
	</div>
	
</body>
</html>
