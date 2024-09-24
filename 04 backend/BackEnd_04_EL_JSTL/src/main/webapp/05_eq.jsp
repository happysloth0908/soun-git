<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EQ</title>
</head>
<body>
	<!-- url에 쿼리 스트링을 작성하면 아이디 볼 수 있음  -->
	<%=request.getParameter("id") %> <br> <!-- null -->
	${param.id} <br> <!-- 공백 -->
	
	== : <%=request.getParameter("id") == "soun"%> <br> <!-- 참조 주소가 달라서 false -->
	equals() : <%=request.getParameter("id").equals("soun")%> <br>
	
	== (EL) : ${param.id == "soun"} <br>
	eq(EL) : ${param.id eq "soun"} <br>
	
</body>
</html>