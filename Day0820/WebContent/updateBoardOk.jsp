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
	b.setNo(Integer.parseInt(request.getParameter("no")));
	b.setTitle(request.getParameter("title"));
	b.setContent(request.getParameter("content"));
	BoardDAO dao = new BoardDAO();
	int re = dao.updateBoard(b);
	if (re>0) {
		response.sendRedirect("listBoard.jsp");
	}else {
		%>
		수정에 실패하였습니다.<br>
		<a href="listBoard.jsp">글목록</a>
		<%
	}
	
	
%>
</body>
</html>