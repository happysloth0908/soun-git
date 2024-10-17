<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
	<h2>단일 파일 업로드</h2>
	<form action="/singleFileUpload" method="POST" enctype="multipart/form-data">
		<input type="file" name="file">
		<button>파일등록</button>
		
	</form>
</body>
</html>
