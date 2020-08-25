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
	String tel = "010-222-2333";
	String title = request.getParameter("title");
	String year = request.getParameter("year");
%>
전화 : <%=tel%>
<br>
title <%=title %>
year <%=year %>
</body>
</html>