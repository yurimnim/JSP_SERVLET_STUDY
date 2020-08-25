<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<body bgcolor="purple">
레드입니다.
<%
	response.sendRedirect("yellow.jsp");	
%>
</body>
</html>