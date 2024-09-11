package com.ssafy.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/mvc/board")
public class BoardFrontServlet extends HttpServlet {
	private List<Board> boards = new ArrayList<>();

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		http://lacalhost:8080/offfline-prj/mvc/board
		String type = req.getParameter("type");
		if (type == null)
			type = "list";

		switch (type) {
		case "list":
			list(req, resp);
			break;
		case "write":
			write(req, resp);
			break;
		case "writeForm":
			writeForm(req, resp);
			break; // 등록 폼으로 데려가주세요

		}
	}

	/*
	 * 게시글 등록 (post 방식) body 부분에 type=write&title=~~&content=~~&writer=~~
	 */
	private void write(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boards.add(new Board(req.getParameter("title"), req.getParameter("writer"), req.getParameter("content")));
		String html = """
				<html>
				<head><title>등록</title>
				<body>
					<script>
						alert("등록되었습니다");
						location.href = "http://localhost/offline-prj/mvc/board";
					</script>
				</body>
			</html>		
				""";
		
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(html);
		out.close();
	
	}

	private void writeForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Write form");
		String html = """
				<!DOCTYPE html>
				<html lang="en">
				<head>
				  <meta charset="UTF-8">
				  <title>Document</title>
				</head>
				<body>
				  <form action="http://localhost/offline-prj/mvc/board" method="post">
				  <input type="hidden" name="type" value="write" />
				    <div><label for="">제목</label><input type="text" name="title" ></div>
				    <div><label for="">내용</label><input type="text" name="context" ></div>
				    <div><label for="">작성자</label><input type="text" name="writer" ></div>
				    <div><button>등록</button></div>
				  </form>
				</body>
				</html>
			""";
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println(html);
		out.close();
	}

	/**
	 * 게시글 목록 (get 방식) http://lacalhost:8080/offfline-prj/mvc/board?type=list
	 */
	private void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String trHtml = "";
		for (Board b : boards) {
			trHtml += """
					<tr>
						<td>%d</td>
						<td>%s</td>
						<td>%s</td>
					</tr>
					""".formatted(b.getNo(), b.getTitle(), b.getWriter());
		}
		if (boards.isEmpty()) {
			trHtml = "<tr><td clospan='3'> 게시글이 존재하지 않습니다.</td></tr>";
		}

		resp.setContentType("text/html; charset=utf-8");
		PrintWriter out = resp.getWriter();
		out.println("""
				<html>
					<head><title>게시판 목록</title></head>
					<body>
						<h2>대전 4반 게시판</h2>
						<table>
							<tr>
								<th>번호</th>
								<th>제목</th>
								<th>글쓴이</th>
							</tr>
							%s
						</table>
						<a href="http://localhost/offline-prj/mvc/board?type=writeForm">글쓰기</a>
					</body>
				</html>
				""".formatted(trHtml));
		out.close();
	}
}
