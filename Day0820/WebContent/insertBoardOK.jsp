<%@page import="com.bit.dao.BoardDAO"%>
<%@page import="com.bit.vo.BoardVO"%>
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
	request.setCharacterEncoding("utf-8");
	BoardVO b = new BoardVO();
	b.setTitle(request.getParameter("title"));
	b.setWriter(request.getParameter("writer"));
	b.setContent(request.getParameter("content"));
	b.setIp(request.getRemoteAddr());
	BoardDAO dao = new BoardDAO();
	int re = dao.insertBoard(b);
	if(re>0) {
		response.sendRedirect("listBoard.jsp");
	}else {
		out.print("<h3>게시물 등록 오류.</h3>");
	}
%>

</body>
</html>