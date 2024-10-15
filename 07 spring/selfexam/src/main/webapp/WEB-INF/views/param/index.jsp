<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파라미터 처리</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/param/test1?id=hong&pass=1111">HttpServletRequest 이용</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/param/test2?id=hong&pass=1111">@RequestParam 이용</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/param/test3?id=hong&pass=1111">@RequestParam - test3 이용</a>
	</h2>
	<h2>
		<a href="${pageContext.request.contextPath}/param/test4?id=hong&password=1111">@User 객체 - test3 이용</a>
	</h2>
</body>
</html>