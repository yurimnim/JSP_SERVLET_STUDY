<%@page import="com.bit.vo.BoardVO"%>
<%@page import="com.bit.dao.BoardDAO"%>
<%@page import="com.bit.vo.BoardVO"%>
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
<%
	int no = Integer.parseInt(request.getParameter("no"));
	BoardDAO dao = new BoardDAO();
	BoardVO b = dao.getBoard(no,true);
%>

<h2>게시물 상세</h2>
<hr>
글번호 : <%= b.getNo() %><br>
글제목 : <%= b.getTitle() %><br>
작성자 : <%= b.getWriter() %><br>
글내용 : <br>
<textarea rows="10" cols="60" readonly="readonly"><%=b.getContent() %></textarea><br>
등록일 : <%= b.getRegdate() %><br>
ip주소: <%= b.getIp() %><br>
조회수 : <%= b.getHit() %><br>
<img  src="upload/<%=b.getFname()%>" width="100" height="100">


<hr>
<a href="member/updateBoard.jsp?no=<%=no%>">수정하기</a>
<a href="member/deleteBoard.jsp?no=<%=no%>">삭제하기</a>
</body>
</html>