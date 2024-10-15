<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Share~! 데이터 공유</h2>
	<h2>공유된 데이터 확인 : ${u}</h2> <!-- 클래스 이름을 소문자로 받은 거 user -->
	<a href="${pageContext.request.contextPath}/share/test1?id=abcd&password=2222">ModelAttribute 공유</a>
	<a href="${pageContext.request.contextPath}/share/test2">Model 공유</a>
	<div>${msg}:::${hi}</div>
	<a href="${pageContext.request.contextPath}/share/test3">Map 공유</a>
	<div>${msg}:::${hi}</div>
</body>
</html>