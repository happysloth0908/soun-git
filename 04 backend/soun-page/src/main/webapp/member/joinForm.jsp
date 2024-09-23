<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입 페이지</h2>
	<form action="<%= request.getContextPath() %>/member" method="post">
		<input type="hidden" name="action" value="join">
		<div>
			<label>Id</label>
			<input type="text" name="id"> <!-- id라는 파라미터에 있는 인풋값을 넘겨줌 -->
		</div>
		<div>		
			<label>password</label>
			<input type="password" name="password">
		</div>
		<div>		
			<label>name</label>
			<input type="text" name="name">
		</div>
		<button>회원가입</button>
	
	</form>
</body>
</html>