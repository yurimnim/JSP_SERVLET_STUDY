<%@page import="com.bit.vo.GoodsVo"%>
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
	int no = Integer.parseInt(request.getParameter("no"));
	GoodsVo g = dao.getGoods(no);
%>

상품번호 : <%=g.getNo() %> <br>
상품이름 : <%=g.getName() %> <br>
상품가격 : <%=g.getPrice() %> <br>
수량 : <%=g.getQty() %> <br>
상품사진:<br>
<img src="./upload/<%=g.getFname()%>" width="200" height="height"><br>
<a href = "deleteGoods.jsp?no=<%=g.getNo()%>">삭제하기 </a> <br>
<a href = "updateGoods.jsp?no=<%=g.getNo()%>">수정하기 </a>
</body>
</html>