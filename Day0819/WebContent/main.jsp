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
	String name= "이순신";
	int age = 20;
%>

<h3><%=name%></h3>
<p><%=age%></p>

<%@include file = "addr.jsp" %>
<hr>
<jsp:include page="tel.jsp">
	<jsp:param value="hello" name="title"/>
	<jsp:param value="2020" name="year"/>
</jsp:include>
</body>
</html>