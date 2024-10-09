<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ include file="/header.jsp" %>
<div class="login_sign">
    <!-- 회원가입 폼 -->
    <div class="container" id="signupForm">
        <h2 >회원가입</h2>
        <form id="signup" action="${pageContext.request.contextPath}/user" mehtod="post">
        	<input type="hidden" name="action" value="signup"/>
            <div class="form-group">
                <input type="text" id="signupUsername" name="id" placeholder="아이디" required>
            </div>
            <div class="form-group">
                <input type="password" id="signupPassword" name="password" placeholder="비밀번호" required>
            </div>
            <div class="form-group">
                <input type="email" id="signupEmail" name="email" placeholder="이메일" required>
            </div>
            <div class="form-group" style="display: flex; gap: 18px;">
                <button type="submit">가입하기</button>
                <button type="submit" id="return">취소</button>
            </div>
            <p class="message" id="signupMessage"></p>
        </form>
        <div class="switch-form">
            <p>이미 계정이 있으신가요?   <a href="${pageContext.request.contextPath}/user?action=loginForm"> 로그인</a></p>
        </div>
    </div>
</div>
<%@ include file="/footer.jsp" %>
</body>


</html>
