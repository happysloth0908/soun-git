<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.board-detail {
		display: inline-block;
	}
</style>
</head>
<body>
	 <h2>게시판 상세</h2>
	 <div class="board-detail">
	 	<label>번호</label>
	 	<div>${board.no}</div>
	 </div>
	 <div class="board-detail">
	 	<label>제목</label>
	 	<div>${board.title}</div>
	 </div>
	 <div class="board-detail">
	 	<label>내용</label>
	 	<div>${board.content}</div>
	 </div>
	 <div class="board-detail">
	 	<label>작성자</label>
	 	<div>${board.writer}</div>
	 </div>
	 <div class="board-detail">
	 	<label>조회수</label>
	 	<div>${board.viewCnt}</div>
	 </div>
	 <div class="board-detail">
	 	<a href="${pageContext.request.contextPath}/board?action=delete&no=${board.no}">삭제</a>
	 	<a href="${pageContext.request.contextPath}/board?action=editForm&no=${board.no}">수정</a>
	 	<a href="${pageContext.request.contextPath}/board?action=list">목록</a>
	 </div>
</body>
</html>