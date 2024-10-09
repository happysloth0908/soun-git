<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<%@ include file="/header.jsp" %>

<div class="login">
    <!-- 로그인 폼 -->
    <div class="container" id="loginForm" style="">
        <h2>로그인</h2>
        <form id="login" action="${pageContext.request.contextPath}/user" method="post">
        	<input type="hidden" name="action" value="login"/>
            <div class="form-group">
                <input type="text" id="loginUsername" name="id" placeholder="아이디" required>
            </div>
            <div class="form-group">
                <input type="password" id="loginPassword" name="password" placeholder="비밀번호" required>
            </div>
            <div class="form-group" style="display: flex; gap:18px;">
                <button class="button" type="submit">로그인</button>
                <button class="button" type="submit" id="return">취소</button>
            </div>
            <p class="message" id="loginMessage"></p>
        </form>
        <div class="switch-form">
            <p>계정이 없으신가요? <a href="${pageContext.request.contextPath}/user?action=signupForm">회원가입</a></p>
        </div>
    </div>
</div>
  <%@ include file="/footer.jsp" %>
  
  
     <script>
       // 로그인 실패 시 alert 창 띄우기
       window.onload = function() {
           <% 
           String loginChk = request.getParameter("loginChk");
           if(loginChk != null){
           	  if (loginChk.equals("failed")) { %>
               alert("틀리거나 없는 계정 입니다. 다시 시도해주세요.");
           <% 
              } 
           }
           %>
       };
   </script>
</body>
</html>
