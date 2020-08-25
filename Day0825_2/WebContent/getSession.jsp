<%@page import="com.bit.vo.Person"%>
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
<h2>세션에 설정된 값 확인</h2>
<%
	String name = (String)session.getAttribute("name");
	int year = (Integer)session.getAttribute("year");
	Person p = (Person)session.getAttribute("p");
	ArrayList<String> list = (ArrayList<String>)session.getAttribute("list");
	
	String title = (String)session.getAttribute("title");
	
%>
title: <%=title %><br>
이름: <%=name %><br>
연도: <%=year %><br>
이름: <%=p.getName() %><br>
나이: <%=p.getAge() %><br>
<%
	for(String a:list) {
		%>
		 <p><%=a %></p>
		<% 
	}

%>
</body>
</html>