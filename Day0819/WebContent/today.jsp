<%@page import="java.util.Date"%>
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
	Date today = new Date();
	int year = today.getYear() + 1900;
	int month = today.getMonth() + 1;
	int day = today.getDate();	
%>

<h3><%=year%>년 <%=month%>월  <%=day%>일</h3>

</body>

</html>