<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
	<h2>인터셉터로 로그인 연습</h2>
	
	<c:if test="${empty name}">
	<div>
	<a href="${pageContext.request.contextPath}/user/loginForm">로그인</a>
	</div>
	</c:if>
	
	<c:if test="${not empty name}">
	
	<div>
		${name}님 환영합니다. 
	</div>
	<div>
	<a href="${pageContext.request.contextPath}/user/logout">로그아웃</a>
	</div>
	</c:if>
	
	<div>
	<a href="${pageContext.request.contextPath}/board/list">유저 게시글 페이지로 가기</a>
	</div>
</body>
</html>
