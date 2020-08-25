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
		font-family: '맑은 고딕';
	}
	
	h2 {
		color: 	#3333cc;
		font-family: '맑은 고딕';
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
<form action ="SearchPension.jsp" method ="post">
<h3>펜션검색:</h3> 
 <input name = "searchfield" type="radio" value ="addr">위치
 <input name = "searchfield" type="radio" value ="facility">시설
 <input type="search" name = "keyword">
<input type = "submit" value ="검색"><br>

<%
	if(request.getMethod().equals("POST")){
		try {
			request.setCharacterEncoding("euc-kr");
			String searchField = request.getParameter("searchfield");
			String keyword = request.getParameter("keyword");
			PensionDAO dao = new PensionDAO();
			ArrayList<PensionVO> list  = dao.serchPension(searchField, keyword);
			%>
				<ul>
			<% 
			for(PensionVO p:list) {
				%>
					<li><a href ="detailPension.jsp?no=<%=p.getNo()%>"><%=p.getName() %></a></li>
				<% 
			}
			%>
			</ul>
			<%
		} catch(Exception e) {
			System.out.println("예외발생 " + e.getMessage());
		}
	}
%>

</form>
</body>
</html>