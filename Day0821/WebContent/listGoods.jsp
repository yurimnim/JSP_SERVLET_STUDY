<%@page import="com.bit.vo.GoodsVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.dao.GoodsDao"%>
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
 GoodsDao dao = new GoodsDao();
 ArrayList<GoodsVo> list = dao.listAll();

%>
<a href ="insertGoods.jsp">상품등록</a></br>
<table border="1">
<tr>
	<th>상품번호</th>
	<th>상품명</th>
	<th>상품가격</th>
</tr>
<%
	for(GoodsVo g :list) {
		%><tr>
			<td><a href="detailGoods.jsp?no=<%=g.getNo()%>"><%=g.getNo() %></a></td>			
			<td><%=g.getName() %></td>
			<td><%=g.getPrice() %></td>
		</tr>	
		<% 
	}
%>
</table>
</body>
</html>