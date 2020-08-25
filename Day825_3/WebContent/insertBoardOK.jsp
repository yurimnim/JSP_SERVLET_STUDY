<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	if(session.getAttribute("member") == null) {
		response.sendRedirect("login.jsp");
	}

	request.setCharacterEncoding("utf-8");
	String path = request.getRealPath("upload");
	System.out.println("path: " + path);
		
	MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*10,"utf-8", new DefaultFileRenamePolicy());
	
	BoardVO b = new BoardVO();
	b.setTitle(multi.getParameter("title"));
	b.setWriter(multi.getParameter("writer"));
	b.setContent(multi.getParameter("content"));
	b.setIp(request.getRemoteAddr());
	b.setFname(multi.getOriginalFileName("fname"));
	b.setPwd(multi.getParameter("pwd"));
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