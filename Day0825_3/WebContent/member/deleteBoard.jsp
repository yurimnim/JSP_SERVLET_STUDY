<%@page import="java.io.File"%>
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
%>
<h2>게시물 삭제</h2>
<form action="member/deleteBoardOk.jsp" method="post">
	<input type="hidden" name="no" value="<%=no%>">
	<input type="password" name="pwd">
	<input type="submit" value="삭제">
</form>


</body>
</html>