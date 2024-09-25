<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>대전 4반 게시판</h2>
	<form action="${pageContext.request.contextPath}/board" method="post">
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="b" items="${list}"> <!-- for문 대체 -->
		<tr>
			<%-- <td><%= b.getNo() %></td> --%>
			<%-- <td>${b.getNo()}</td> --%>
			
			<td>${b.no}</td> <!-- 이렇게 간출여 쓸 수 있게 해줌  -->
			<td><a href="${pageContext.request.contextPath}/board?action=detail&no=${b.no}">${b.title}</a></td>
			<td>${b.writer}</td>
			<td>${b.viewCnt}</td>
			</tr>
		</c:forEach>
		
	</table>
	</form>
	<%-- <a href="<%= request.getContextPath() %>/board?action=writeForm">글쓰기</a>	
 --%>	
 
 	<a href="${pageContext.request.contextPath}/board?action=writeForm">글쓰기</a>	
 	<%-- <a href="${request.contextPath}/board?action=writeForm">글쓰기</a> --%>	
	<!-- 이렇게 쓰면 안 됨. 왜냐면 앞에 아무것도 없으니 el의 기본 객체 중에서 찾으려고 할거임 -->
</body>
</html>







