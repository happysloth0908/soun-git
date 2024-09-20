<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>대전 4반 게시판</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
		<tr>
			<th>1</th>
			<th>연습중</th>
			<th>소운</th>
			<th>5</th>
		</tr>
	</table>
<!-- 	<a href="/writeForm.jsp">글쓰기</a>  이러면 안 돼!! 무조건 서블렛으로 가야해!~!--> 
	<a href="/board-step01-mvc/board?action=writeForm">글쓰기</a>
</body>
</html>