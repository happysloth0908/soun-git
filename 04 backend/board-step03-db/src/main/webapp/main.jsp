
<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" scope="page"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
	<header>
		<nav>
			<ul>
			<c:choose>
				<c:when test="${empty memberInfo}">
				<li><a href="${contextPath}/member?action=loginForm">로그인</a></li>
				<li><a href="${contextPath}/member?action=joinForm">회원가입</a></li>
				</c:when>
				<c:otherwise>
				<li><a href="">마이페이지</a></li>
				<li><a href="${contextPath}/member?action=Logout">로그아웃</a></li>				
				</c:otherwise>
			</c:choose>
			
			</ul>
		</nav>
	</header>
	<h2>대전 4반 - 메인 페이지</h2>
	<div>
		<a href="${contextPath}/board?action=list">게시판 이동</a>
	</div>
</body>
</html>






