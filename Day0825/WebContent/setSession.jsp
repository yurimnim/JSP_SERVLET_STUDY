<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.vo.Person"%>
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
	String name = "이순신";
	session.setAttribute("name", name);
	
	int year = 2020;
	session.setAttribute("year", year);
	
	Person p = new Person("고길동", 40);
	session.setAttribute("p", p);
	
	ArrayList<String> list = new ArrayList<String>();
	list.add("사과");
	list.add("포도");
	list.add("수박");
	
	session.setAttribute("list", list);
%>

세션변수의 값을 설정하였습니다. <br>
<a href="getSession.jsp">세션변수 값 확인하기</a>
</body>
</html>