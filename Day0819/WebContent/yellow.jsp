<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<body bgcolor="yellow">
엘로

<%
	String year=request.getParameter("year");
	String title =request.getParameter("title");
%>
year: <%=year%>
title: <%=title%>

</body>
</html>