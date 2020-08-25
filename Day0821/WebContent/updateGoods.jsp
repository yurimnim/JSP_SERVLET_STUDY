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
		int no = Integer.parseInt(request.getParameter("no"));
		GoodsDao dao = new GoodsDao();
		GoodsVo g = dao.getGoods(no);

	%>	
	<h2>상품수정</h2>
	<form action="updateGoodsOK.jsp" method="post" enctype="multipart/form-data">
		상품번호: <%=g.getNo() %>		
		<input type="hidden" name="no" value="<%=g.getNo()%>"><br>
		상품이름: <input type="text" name="name" value="<%=g.getName()%>"><br>
		상품가격: <input type="text" name="price" value="<%=g.getPrice()%>"><br>
		상품수량: <input type="text" name="qty" value="<%=g.getQty()%>"><br>
		<input type="hidden" name="oldFname" value="<%=g.getFname()%>">
		상품사진: <input type="file" name="fname"><br>	
		<img src = "upload/<%=g.getFname()%>" width="50" height="50">
		<input type="submit" value="확인">
		<input type="reset" value="취소">		
	</form>	
</body>
</html>