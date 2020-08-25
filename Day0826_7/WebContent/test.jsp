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
	int i = 0;
	int j = 0;
	if(session.getAttribute("i") != null) {
		i = (Integer)session.getAttribute("i");
	}
	
	if(application.getAttribute("j") != null) {
		j = (Integer)application.getAttribute("j");
	}
	
	i++;
	j++;
	%>
	session 변수 i: <%=i %><br>
	application 변수j: <%=j %><br>
	<% 
	session.setAttribute("i", i);
	application.setAttribute("j", j);
%>
</body>
</html>