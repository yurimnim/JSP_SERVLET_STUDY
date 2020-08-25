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
	int re = dao.deleteBoard(no);
	
	if (re>0) {
		response.sendRedirect("listBoard.jsp");
	}else {
		%>
		삭제에 실패하였습니다.<br>
		<a href="listBoard.jsp">글목록</a>
		<%
	}	
%>

</body>
</html>