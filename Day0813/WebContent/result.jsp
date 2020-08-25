<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("euc-kr");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String job = request.getParameter("job");
	String area = request.getParameter("area");
	String gender = request.getParameter("gender");
	String bt = request.getParameter("bt");
	String[] hb = request.getParameterValues("hb");
	String[] skill = request.getParameterValues("skill");
	String info = request.getParameter("info");	
	info = info.replace("\r\n", "<br>");
%>
입력한 정보는 다음과 같습니다.<br>
ID: <%= id %><br>
PWD: <%= pwd %><br>
NAME: <%= name %><br>
AGE: <%= age %><br>
JOB: <%= job %><br>
REGION: <%= area %><br>
GENDER: <%= gender %><br>
BLOODTYPE: <%= bt %><br>
HOBBIES: <% 
	for(String h: hb) {
%>
	<%=h %>	&nbsp;	 	
	<%
}
%>
SKILLS: <% 
	for(String s: skill) {
%>
	<%=s %>	&nbsp;	 	
	<%
}
%><br>
INFO:<br> 
<%= info %><br>

</body>
</html>