<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<style>
	h3 {
		font-family: '���� ���';
	}
	
	h2 {
		color: 	#3333cc;
		font-family: '���� ���';
		font-weight: bold;
		font-size: 25px;
		text-shadow: 3px 3px 10px #d6d6f5;
	}
		
	.title {
		font-weight: bold;
		color: #5933cc;
	}
		
	p {
		color: green;
		text-decoration: underline;
	}

</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action ="pension.jsp" method ="post">
<h3>��ǹ�ȣ �˻�:</h3> <input type="search" name = "no"> 
<input type = "submit" value ="�˻�"><br>
<%
	if(request.getMethod().equals("POST")){
		String sql = "select * from pension where no=?";
		String driver="oracle.jdbc.driver.OracleDriver";
		String url="jdbc:oracle:thin:@192.168.0.49:1521:XE";
		String pwd="madang";
		String user="c##madang";
		try{			
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, pwd);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			int no = Integer.parseInt(request.getParameter("no"));
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
			%>
			 	<h2><%=rs.getString(2)%> ��� �ȳ�</h2>
			 	<ul>
			 		<li><span class="title">�ּ�: </span><%=rs.getString(3) %></li>
			 		<li><span class="title">��ȭ��ȣ:</span> <%=rs.getString(4)%></li>
			 		<li><span class="title">���� ��:</span> <%=rs.getString(5)%></li>
			 		<li><span class="title">�δ�ü�:</span> <%=rs.getString(6)%></li>
			 	</ul>
			 	<p><%=rs.getString(7) %></p>
			<%
			}
		} catch(Exception e) {
			System.out.println("���ܹ߻� " + e.getMessage());
		}
	}	
%>
</form>
</body>
</html>