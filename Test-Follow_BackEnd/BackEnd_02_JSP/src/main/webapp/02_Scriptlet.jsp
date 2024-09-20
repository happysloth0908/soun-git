<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스크립트릿</title>
</head>
<body>
	<h2>스크립트릿 연습</h2>
	<%
		int A = 10;
		int B = 20;
		
		int sum = A + B;
		
		/* sysout  콘솔 x,  사용자에게 보여주기 위한 화면을 만드는 중임. */
		
		out.print(A + "+" + B + "+" + "=" + sum);
		
	%>

	<a href="index.html">홈으로</a>
</body>
</html>
