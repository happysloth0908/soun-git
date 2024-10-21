<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
	<form method="POST" action="${pageContext.request.contextPath}/board/write" 
		enctype="multipart/form-data">

		<!-- enctype="application/x-www-form-urlencoded" -->
		<h2>글쓰기</h2>
		<div>
			제목 <input type="text" name="title" required="required">
		</div>
		<div>
			글쓴이 <input type="text" name="writer" required="required">
		</div>
		<div>
			내용
			<textarea type="text" name="content" placeholder="글 내용을 입력하세요" required="required"></textarea>
		</div>
		<div>
			파일첨부
			<input type="file" name="attach" >
		</div>

		<button>등록하기</button>
	</form>
</body>
</html>
