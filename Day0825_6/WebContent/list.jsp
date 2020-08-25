<%@page import="java.util.ArrayList"%>
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
	ArrayList<String> list = new ArrayList<String>();
	list.add("사과");
	list.add("포도");
	list.add("수박");
%>
3번째 요소: <%=list.get(3) %>
</body>
</html>