<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8" %>
   <%!
   String memberMsg = "Member 메세지";
   public void call(){}
   %> 
   <%
   String msg = "jsp 연습 메세지";
   // public void call(){} 이건 메서드에 들어가기 때문에 메서드 안에 메서드는 놉!!!
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>메세지 : <%= msg %></h2>
<h2>메세지 : <% out.print(msg); %></h2> <%--위 문장이랑 같은 말임.  --%>
</body>
</html>