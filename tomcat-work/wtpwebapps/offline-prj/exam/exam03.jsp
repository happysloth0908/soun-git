<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
// request 가 없는데 오류가 안 생김. 선언 없이도 내장된 파라미터가 있음. 
int dan = Integer.parseInt(request.getParameter("dan"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		margin: 0; padding: 0; box-sizing: boarder-box;
	}

	table {
		width: 500px;
		margin: 100px auto;
}
	table, td {
	border: 1px solid #3455;
}
	td, th {
		padding: 4px;
	}
</style>
</head>
<body>
	<div class="container">
		<table>
		<tr>
		<th>3단</th>
		</tr>
		<%
		for (int i =0; i < 10; i++){		
		%>
		<tr>
		<td><%= dan %> * <%= i %> = <%= dan * i %></td>
		</tr>
		<% 
		}
		%>		
		
	
		</table>
		<a href="exam03-input.jsp">다시 입력</a>
	</div>
</body>
</html>