<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.bit.dao.GoodsDao"%>
<%@page import="com.bit.vo.GoodsVo"%>
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
	request.setCharacterEncoding("utf-8");
	String path = request.getRealPath("upload");
	System.out.println("path: " + path);
	
	MultipartRequest multi = new MultipartRequest(request, path,1024*1024*10,"utf-8");
	
	GoodsVo g = new GoodsVo();
	g.setNo(Integer.parseInt(multi.getParameter("no")));
	g.setName(multi.getParameter("name"));
	g.setPrice(Integer.parseInt(multi.getParameter("price")));
	g.setQty(Integer.parseInt(multi.getParameter("qty")));
	g.setFname(multi.getOriginalFileName("fname"));
	
	GoodsDao dao = new GoodsDao();
	int re = dao.insertGoods(g);
	if(re>0) {
		response.sendRedirect("listGoods.jsp");
	}else {
		out.print("<h3>상품등록 오류</h3>");
	}
%>
</body>
</html>