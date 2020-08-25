<%@page import="com.bit.vo.PensionVO"%>
<%@page import="com.bit.dao.PensionDAO"%>
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
	int no = Integer.parseInt(request.getParameter("no"));
	PensionDAO dao = new PensionDAO();
	PensionVO p = dao.getPension(no);
%>
<h2><%= p.getName() %>펜션 안내</h2>
					<ul>
						<li><span class="title">주소:</span><%=p.getAddr() %></li>
						<li><span class="title">전화번호:</span><%=p.getTel() %></li>
						<li><span class="title">객실 수:</span><%=p.getRooms() %>개</li>
						<li><span class="title">부대시설:</span><%=p.getFacility() %></li>
					</ul>
					<br>
					<p class="etc">※<%=p.getEtc() %></p>
</body>
</html>