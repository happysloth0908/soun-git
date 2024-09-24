<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="${pageContext.request.contextPath}/member" method="post">
	<input type="hidden" name="action" value="join" />
		<div>
			<label>아이디</label>
			<input type="text" name="id" />
		</div>
		<div>
			<label>이름</label>
			<input type="text" name="name" />
		</div>
		<div>
			<label>비밀번호</label>
			<input type="password" name="password" />
		</div>
		<div>
			<button>가입</button>
		</div>
	</form>
</body>
</html>