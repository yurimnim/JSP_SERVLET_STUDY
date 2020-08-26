<%@page import="com.bit.vo.GoodsVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%
	GoodsVo g= (GoodsVo)request.getAttribute("g");
%>
<body>
	<h2>상품상세</h2>
	<hr>
	상품번호: <%=g.getNo() %><br>
	상품명: <%=g.getName() %><br>
	가격: <%=g.getPrice() %><br>
	수량: <%=g.getQty() %><br>
	<img src="upload/<%=g.getFname() %>" width="100" height="100">
</body>
</html>