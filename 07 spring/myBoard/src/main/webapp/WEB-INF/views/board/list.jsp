<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
	<h2>게시판 정보</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="board" items="${list}">
			<tr>
				<td>${board.no}</td>
				<td><a href="${pageContext.request.contextPath}/board/detail?no=${board.no}">${board.title}</a></td>
				<td>${board.writer}</td>
				<td>${board.viewCnt}</td>
				<td>${board.regDate}</td>
			</tr>
		</c:forEach>
		
		<div>
			<a href="${pageContext.request.contextPath}/board/writeForm">글 등록</a>
		</div>
		
	</table>
		<!--  paging 영역 설정 -->
	<div>
		<c:if test="${pr.prev}">
			<a href="list?page=1">[첫페이지]</a>
			<a href="list?page=${pr.beginPage - 1}">[이전]</a>
		</c:if>
		<c:forEach var="i" begin="${pr.beginPage}" end="${pr.endPage}">
			<a href="list?page=${i}">[${i}]</a>
		</c:forEach>
		<c:if test="${pr.next}">
			<a href="list?page=${pr.endPage + 1}">[다음]</a>
			<a href="list?page=${pr.lastPage}">[마지막페이지]</a>
		</c:if>
	</div>
	
</body>
</html>
