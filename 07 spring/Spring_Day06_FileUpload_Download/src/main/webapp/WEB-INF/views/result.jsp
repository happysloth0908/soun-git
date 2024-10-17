<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title>결과</title>
</head>
<body>
	
	<a href="/img/${fileName}">${fileName}</a>
	<img src="img/${fileName}">
	
	<a href="download?fileName=${fileName}">이미지 다운로드</a>
</body>
</html>
