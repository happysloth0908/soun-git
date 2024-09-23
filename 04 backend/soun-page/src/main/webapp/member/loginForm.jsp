<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>로그인 페이지</h2>
	<form action="<%= request.getContextPath() %>/member" method="post">
	<input type="hidden" name="action" value="login">
	<div>
		<label>아이디</label>
		<input type="text" name="id" placeholder="아이디를 입력하세요">
	</div>	
	<div>
		<label>비밀번호</label>
		<input type="password" name="password" placeholder="비밀번호 입력하세용">
	</div>	
	<button>로그인</button>
	</form>
</body>
</html>