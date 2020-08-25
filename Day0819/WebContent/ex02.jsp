<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
 <%! 
 	public int add(int n) {	
	 return n+100;
 }
 	String title = "hello";
	
 	/*
	 <%!선언문에는 반복문이 올 수 없다!	 
	*/

 %>
 <%=title%>
 <%
 	String addr = "서울시 마포구 신수동";
 %>
 <%=addr%> <br>
 <%=add(5) %>
</body>
</html>