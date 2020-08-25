<%@page import="com.bit.vo.BoardVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.dao.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	* {
		font-family: 'Noto Sans KR';
	}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>게시물 목록</h2>
	<hr>
	<%
		BoardDAO dao = new BoardDAO();
		ArrayList<BoardVO> list = dao.listAll();
	%>
	<a href="insertBoard.jsp">게시물 등록</a><br>
	<table border="1" width="60%">
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
		</tr>
		<%
			for(BoardVO b:list){
				%>
				<tr>
					<td><%= b.getNo() %> </td>
					<td><a href="detailBoard.jsp?no=<%=b.getNo()%>"><%= b.getTitle()%></a></td>
					<td><%= b.getWriter() %> </td>
				</tr>
				<%
			}
		%>		
	</table>
</body>
</html>
