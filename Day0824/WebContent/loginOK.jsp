<%@page import="com.bit.dao.MemberDAO"%>
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
	request.setCharacterEncoding("utf-8");
	String id = request.getParameter("id");
	String pwd = request.getParameter("pwd");
	MemberDAO dao =  new MemberDAO();
	int re = dao.isMember(id, pwd);
	if(re==0) {
		response.sendRedirect("listBoard.jsp");
	}else if(re==1){
		response.sendRedirect("login.jsp");		
	}else if(re==-2) {
		
	} else {
		
	}
%>
</body>
</html>