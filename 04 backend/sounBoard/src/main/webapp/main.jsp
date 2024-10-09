<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>4반 유성온천역 스터디 메인화면</title>
  <style>
    * {
      margin: 0;
      padding: 0;
      box-sizing: border-box;
    }

    nav {
      display: flex;
      justify-content: space-between;
      padding: 30px;
      border-bottom: 1px solid;
    }

    h3 {
      margin: 50px;
    }

    button {
      margin: 50px;
    }
  </style>
</head>
<body>
  <header>
    <nav>
      <div>
        <h2>유온스터디</h2>
      </div>
      <div>
        <a href="">로그인</a>
        <a href="">회원가입</a>
      </div>
    </nav>
  </header>
  <main>
    <h3>스터디에 오신 것을 환영합니다</h3>
    <a href="${pageContext.request.contextPath}/board?action=list">
    	<button type="button">목록으로</button>
	</a>
  </main>
  <footer></footer>
</body>
</html>