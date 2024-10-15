<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title></title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/board/write" method="POST">
		<h2>글쓰기</h2>
		<div>
			제목 <input type="text" name="no">
		</div>
		<div>
			글쓴이 <input type="text" name="writer">
		</div>
		<div>
			내용
			<textarea type="text" name="content" placeholder="글 내용을 입력하세요"></textarea>
		</div>

		<button>등록하기</button>
	</form>
</body>
</html>
