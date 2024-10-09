<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 상세</title>
</head>
<body>
	<h2>글 상세 보기</h2>
	
	<div>글번호</div>
	<div>${board.no}</div>
	<div>문제 번호</div>
	<div>${board.probNo}</div>
	<div>문제 이름</div>
	<div>${board.probName}</div>
	<div>출처</div>
	<div>${board.source}</div>
	<div>작성자</div>
	<div>${board.writer}</div>
	<div>풀이</div>
	<div>${board.ans}</div>
	<div>작성 시간</div>
	<div>${board.time}</div>
	<div>조회수</div>
	<div>${board.viewCnt}</div>
	
	<form action="${pageContext.request.contextPath}/board?action=delete" method="POST">
	<input type="hidden" name="no" value="${board.no}">
	<button>삭제</button>
	</form>
</body>
</html>