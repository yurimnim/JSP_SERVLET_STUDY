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
	list.add("고길동");
	list.add("박또치");
	list.add("김둘리");
	list.add("마이콜");
	list.add("김희동");
%>

<ul>
	<%
		for(String s: list) {
			%>
			<li><%=s%></li>
			<% 
		}
	%>
</ul>

</body>
</html>