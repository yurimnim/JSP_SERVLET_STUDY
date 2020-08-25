<%@page import="java.util.Enumeration"%>
<%@page import="com.bit.util.Logging"%>
<%@page import="java.util.Arrays"%>
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
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name");
	String[] hb = request.getParameterValues("hb");
	String[] food = request.getParameterValues("food");
	String ip = request.getRemoteAddr();
	Logging log = new Logging();
	log.printLog(ip);	
	String url = request.getRequestURL().toString();
	String uri = request.getRequestURI();
	Enumeration e = request.getParameterNames();
	
%>
<%=name%> 님 죽겠어요. <br>
취미: <%=Arrays.toString(hb) %><br>
좋아하는 것:<%=Arrays.toString(food) %><br>
url: <%=url %> <br>
uri: <%=uri %><br>
파라메터 이름들 :<%
	while(e.hasMoreElements()) {
		out.print(e.nextElement() + " ");
	}	
%>
</body>
</html>