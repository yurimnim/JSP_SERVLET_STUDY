<%@page import="com.bit.vo.PensionVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.dao.PensionDAO"%>
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
		font-family: '���� ����';
	}
	
	h2 {
		color: 	#3333cc;
		font-family: '���� ����';
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
<h3>��ǰ˻�:</h3> 
 <input name = "searchfield" type="radio" value ="addr">��ġ
 <input name = "searchfield" type="radio" value ="facility">�ü�
 <input type="search" name = "keyword">
<input type = "submit" value ="�˻�"><br>

<%
	if(request.getMethod().equals("POST")){
		try {
			request.setCharacterEncoding("euc-kr");
			String searchField = request.getParameter("searchfield");
			String keyword = request.getParameter("keyword");
			PensionDAO dao = new PensionDAO();
			ArrayList<PensionVO> list  = dao.serchPension(searchField, keyword);
			for(PensionVO p:list) {
				%>
				<h2><%= p.getName() %>��Ǿȳ�</h2>
				<ul>
					<li><span class="title">�ּ�: </span><%=p.getAddr() %></li>
			 		<li><span class="title">��ȭ��ȣ:</span> <%=p.getTel()%></li>
			 		<li><span class="title">���� ��:</span> <%=p.getRooms()%></li>
			 		<li><span class="title">�δ�ü�:</span> <%=p.getFacility()%></li>				
				</ul>
				<p><%=p.getEtc() %></p>
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