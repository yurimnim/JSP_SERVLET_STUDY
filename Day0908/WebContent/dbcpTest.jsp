<%@page import="javax.sql.DataSource"%>
<%@page import="java.sql.Connection"%>

<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
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
	try{
		//현재 프로젝트 context 에 설정된	resource 를 찾기위해서 context 객체를 생성한다. 
		Context context = new InitialContext();
		//context 객체를 통해서 등록된 resource를 찾는
		DataSource ds = (DataSource)context.lookup("java:comp/env/my");
		
		Connection conn = ds.getConnection();
		out.print("연결성공 ");
		out.print(conn);
	}catch(Exception e) {
		System.out.println("예외발생 "+ e.getMessage());
	}
%>
</body>
</html>