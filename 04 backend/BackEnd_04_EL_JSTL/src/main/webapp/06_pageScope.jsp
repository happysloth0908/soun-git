<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL</title>
</head>
<body>
	<%
	//pageContext.setAttribute("name", "page yang");
	request.setAttribute("name", "request yang");
	session.setAttribute("name", "session yang");
	application.setAttribute("name", "application yang");
	%>
	
	JSP Page 영역 접근 : <%=pageContext.getAttribute("name") %><br> <!-- 자바코드에서는 그냥 null 출력하라하면 null 출력함 -->
	EL (Page) : ${pageScope.name} <br> <!-- El 은 그냥 규정이 그럼. null 출력은 공백 -->
	EL (Request) : ${requestScope.name} <br> 
	EL (Session) : ${sessionScope.name} <br>
	EL (Application) : ${applicationScope.name} <br>
	
	
	그냥 속성 작성 : ${name } <br> <!-- 스코프 안 정해두면 제일 범위가 작은 스코프부터 찾음.  -->
	<!-- EL은 딱히 앞에 적힌거 없으면 공유영역에서 찾게 됨. -->
	
	쿠키(대괄호 접근) : ${cookie["JSESSIONID"].value} <br>
	쿠키(. dot 접근) : ${cookie.JSESSIONID.value} <br>
	
	
	
	
</body>
</html>