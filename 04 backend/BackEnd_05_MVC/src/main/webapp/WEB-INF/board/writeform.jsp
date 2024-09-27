<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시글 등록</h2>
	<form action="board" method="POST"></form> <!-- 여기 액션이랑 우리가 만든 변수 액션 다름 -->
		<input type="hidden" name="action" value="write">
		<div>
			글 제목 :<input type="text" name="title">
		</div>
		<div>
			글 쓰니 :<input type="text" name="writer" value="익명">
		</div>
		<div>
			글 내용 :<textarea rows="10" cols="30" name="content"></textarea>
		</div>
		<div>
			글 내용:<input type="submit" value="게시글 등록">
		</div>
		
		
</body>
</html>