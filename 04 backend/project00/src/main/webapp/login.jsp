<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- CUSTOM CSS -->
  	<link href="assets/css/custom.css" rel="stylesheet">
    
    <title>로그인</title>
</head>

<body class="login">
    <!-- 회원가입 폼 -->
    <div class="container" id="signupForm" style="display: none;">
        <h2 style="color: white;">회원가입</h2>
        <form id="signup">
            <div class="form-group">
                <input type="text" id="signupUsername" name="signupUsername" placeholder="아이디" required>
            </div>
            <div class="form-group">
                <input type="password" id="signupPassword" name="signupPassword" placeholder="비밀번호" required>
            </div>
            <div class="form-group">
                <input type="email" id="signupEmail" name="signupEmail" placeholder="이메일" required>
            </div>
            <div class="form-group" style="display: flex;">
                <button type="submit">가입하기</button>
                <button type="submit" id="return">취소</button>
            </div>
            <p class="message" id="signupMessage"></p>
        </form>
        <div class="switch-form">
            <p style="color: white;">이미 계정이 있으신가요?   <a href="#" onclick="showLoginForm()"> 로그인</a></p>
        </div>
    </div>

    <!-- 로그인 폼 -->
    <div class="container" id="loginForm" style="">
        <h2>로그인</h2>
        <form id="login">
            <div class="form-group">
                <input type="text" id="loginUsername" name="loginUsername" placeholder="아이디" required>
            </div>
            <div class="form-group">
                <input type="password" id="loginPassword" name="loginPassword" placeholder="비밀번호" required>
            </div>
            <div class="form-group" style="display: flex;">
                <button type="submit">로그인</button>
                <button type="submit" id="return">취소</button>
            </div>
            <p class="message" id="loginMessage"></p>
        </form>
        <div class="switch-form">
            <p>계정이 없으신가요? <a href="#" onclick="showSignupForm()">회원가입</a></p>
        </div>
    </div>

    <script>
        function showSignupForm() {
            document.getElementById('signupForm').style.display = 'block';
            document.getElementById('loginForm').style.display = 'none';
        }

        function showLoginForm() {
            document.getElementById('signupForm').style.display = 'none';
            document.getElementById('loginForm').style.display = 'block';
        }

        // 회원가입 폼 제출 이벤트 핸들러
        document.getElementById('signup').addEventListener('submit', function(event) {
            event.preventDefault(); // 폼 제출 방지
            var username = document.getElementById('signupUsername').value;
            var password = document.getElementById('signupPassword').value;
            var email = document.getElementById('signupEmail').value;

            // 로컬 저장소에 사용자 정보 저장
            if (localStorage.getItem(username)) {
                document.getElementById('signupMessage').innerText = '이미 존재하는 아이디입니다.';
            } else {
                localStorage.setItem(username, JSON.stringify({ password: password, email: email }));
                document.getElementById('signupMessage').innerText = '회원가입이 완료되었습니다!';
                document.getElementById('signup').reset();
            }
        });

        // 로그인 폼 제출 이벤트 핸들러
        document.getElementById('login').addEventListener('submit', function(event) {
            event.preventDefault(); // 폼 제출 방지
            var username = document.getElementById('loginUsername').value;
            var password = document.getElementById('loginPassword').value;

            // 로컬 저장소에서 사용자 정보 확인
            var storedUser = localStorage.getItem(username);
            if (storedUser) {
                var userData = JSON.parse(storedUser);
                if (userData.password === password) {
                    document.getElementById('loginMessage').innerText = '로그인 성공!';
                } else {
                    document.getElementById('loginMessage').innerText = '비밀번호가 틀렸습니다.';
                }
            } else {
                document.getElementById('loginMessage').innerText = '존재하지 않는 아이디입니다.';
            }
        });
    </script>
</body>
</html>
