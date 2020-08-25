<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.dao.CustomerDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h2>고객목록</h2>
<ul>
<%
	CustomerDAO dao = new CustomerDAO();
	ArrayList<String> list = dao.listName();
	for(String name:list) {
		%>
		<li><%=name %></li>
		<% 
	}
%>
</ul>
</body>
</html>