<%@page import="com.bit.vo.PlantsVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.dao.PlantsDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	* {
		padding: 0;
		margin: 0;
		font-family: 'Noto Sans KR';
	}
	
	h3 {
		color: #3d8250;
	}
	
	body {
		margin:10px;
	}
	
	li {
		list-style: none;
	}
	
	#image {
		float: left;
	}
	
	#desc {
		float: left;
		width: 300px;
		margin-left: 30px;
		font-weight: 200;
	}
	
	#menu {
		float: right;
		padding: 20px;
		font-weight: 400;
	}
	
	#menu li {
		padding: 5px;
		border-bottom: dashed 1px #3d8250;
	}
	
	
	img {
		width: 400px;
	}
	
	a {
		text-decoration: none;
		color: black;
	}
	
	table {
		clear: both;
	}
	
</style>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	PlantsDAO dao = new PlantsDAO();
	int no = 1;
	if(request.getParameter("no") != null) {
		no = Integer.parseInt(request.getParameter("no"));
	}
	ArrayList<PlantsVO> list = dao.listAll();
	PlantsVO p = dao.getPlants(no);
	
%>
	<div id = 'image'>
		<img src="img/<%=p.getFname()%>">
	</div>
	
	<div id = 'desc'>
		<h3><%=p.getName() %></h3>
		<p><%=p.getInfo() %></p>
	</div>
	
	<ul id ='menu'>
	<%
		for(PlantsVO vo:list) {
			%>
			<li><a href = 'Float_db.jsp?no=<%=vo.getNo()%>'><%=vo.getName() %></a>
			</li>
			<% 
		}
	%>		
	</ul>
	<table border='1' width='60%'>
	<tr>
		<td>이름</td>
		<td>나이</td>
		<td>주소</td>
		<td>전화</td>
	</tr>
	<tr>
		<td>홍길동</td>
		<td>20</td>
		<td>서울</td>
		<td>010-111-1111</td>
	</tr>	
	<tr>
		<td>고길동</td>
		<td>40</td>
		<td>대전</td>
		<td>010-121-1221</td>
	</tr>	
	<tr>
		<td>박또치</td>
		<td>15</td>
		<td>광주</td>
		<td>010-313-3333</td>
	</tr>		
	</table>
	
</body>
</html>