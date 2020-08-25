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
<%@include file ="loginCheck.jsp" %>
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDAO dao = new BoardDAO();
	BoardVO b = dao.getBoard(no, false);
	
%>

<h2>게시물 수정</h2>
	<hr>
	<form action="updateBoardOk.jsp" method="post" enctype="multipart/form-data">
		<input type="hidden" name="no" value="<%=no%>">
		글제목 : <input type="text" name="title" value="<%=b.getTitle()%>"><br>	
		작성자 : <%= b.getWriter() %><br>
		암호 : <input type="password" name="pwd"><br>
		글내용 : <br>
		<textarea rows="10" cols="60" name="content"><%=b.getContent() %></textarea><br>
		<%
			if(b.getFname() != null){
				%>
				<img  src="upload/<%=b.getFname()%>" width="50" height="50">		
				<%
			}
		%>
		<input type="hidden" name="oldFname" value="<%=b.getFname()%>">
		<input type="file" name="fname"><br>
		<input type="submit" value="수정">	
	</form>
</body>
</html>