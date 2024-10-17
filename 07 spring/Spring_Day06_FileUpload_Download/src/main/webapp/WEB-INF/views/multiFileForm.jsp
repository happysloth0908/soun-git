<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<title></title>
</head>
<body>
	<h2> 다중 파일 업로드</h2>
	<form action="multiFileUpload" method="POST" enctype="multipart/form-data">
		<input type="file" name="files" multiple="multiple">
		<button>파일등록</button>
		
	</form>
</body>
</html>
