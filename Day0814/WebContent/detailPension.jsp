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
<h2><%= p.getName() %>��� �ȳ�</h2>
					<ul>
						<li><span class="title">�ּ�:</span><%=p.getAddr() %></li>
						<li><span class="title">��ȭ��ȣ:</span><%=p.getTel() %></li>
						<li><span class="title">���� ��:</span><%=p.getRooms() %>��</li>
						<li><span class="title">�δ�ü�:</span><%=p.getFacility() %></li>
					</ul>
					<br>
					<p class="etc">��<%=p.getEtc() %></p>
</body>
</html>