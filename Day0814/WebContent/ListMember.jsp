<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	li{
		list-style-image: url('./img/listimg.png');
	}
</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	String sql = "select name from customer";
	String driver="oracle.jdbc.driver.OracleDriver";
	String url="jdbc:oracle:thin:@192.168.0.49:1521:XE";
	String pwd="madang";
	String user="c##madang";
	
	try {
		Class.forName(driver);
		Connection conn = DriverManager.getConnection(url,user,pwd);
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while(rs.next()){
			%>
			<ul>
				<li><%= rs.getString(1) %></li></ul>
			<%
		}
		rs.close();
		stmt.close();
		conn.close();		
	}catch(Exception e) {
		System.out.println("예외발생" + e.getMessage());
	}
%>

</body>
</html>