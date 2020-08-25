<%@page import="com.bit.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h2>게시물 등록</h2>
	<hr>
	<form action="member/insertBoardOK.jsp" method="post" enctype="multipart/form-data">
		글제목: <input type="text" name="title"><br>
		작성자: <input type="text" name="writer"><br>
		글내용: <br>
		<textarea rows= "10" cols="60" name="content"></textarea><br>
		사진등록: <input type="file" name="fname"> <br>
		비밀번호: <input type="password" name="pwd"><br>		
		<input type="submit" value="등록">		
	</form>
	
	<h2>게시물 목록</h2>
	<hr> 
	<%
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.listAll();
	%>
	<a href = "member/insertBoard.jsp">게시물 등록</a>
	
	<table border="1" width="60%">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<%
			for(BoardVO b : list) {						
		%>
		<tr>
			<td><%=b.getNo() %></td>
			<td><%=b.getTitle() %></td>
			<td><%=b.getWriter() %></td>
		</tr>
		<%
	
			}	
		%>
		
	</table>
	
	
</body>
</html>