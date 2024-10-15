<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>Hello jsp</title>
</head>
<body>
	<h2>Hello JSP</h2>
<!-- 로그인 안 했으면 로그인 페이지 -->
	<c:if test="${empty loginUser}">	
		<a href="login">로그인</a>
	</c:if>
<!-- 로그인 했으면 로그아웃  -->
	<c:if test="${not empty loginUser}">	
 		<span>${loginUser}님 반갑습니다</span>
 		<a href="/logout">로그아웃</a>
	</c:if>
	<h3>${msg}</h3>
</body>
</html>
