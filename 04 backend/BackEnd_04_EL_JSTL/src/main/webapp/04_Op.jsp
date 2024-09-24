<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	\${5+2} : ${5+2} <br> <!-- 실수 연산도 해준다!  -->
	\${5+2} : ${5/2} <br> 
	\${5 div 2} : ${5 div 2} <br> <!-- 빨간 줄 어쩔 수 없음.... -->
	\${5 gt 2} : ${5 gt 2} <br>
	\${5 < 2} : ${5 < 2} <br>
	
</body>
</html>