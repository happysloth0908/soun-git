<%@page import="com.soun.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%
 	Member memberInfo = (Member)request.getAttribute("id"); // setAttribute 를 할 때 object 로 저장이 되기 때문에 다시 바꿔주기
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>소운이의 게시판</h2>
	<div>
		<ul>
		<%
		if (memberInfo == null){
		%>
			<li><a href="">로그인</a></li>		
		<%
		}
		%>
			<li><a href="<%= request.getContextPath()%>/member?action=joinForm">회원가입</a></li>
		</ul>
	</div>
</body>
</html>