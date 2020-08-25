<%@page import="java.io.File"%>
<%@page import="com.bit.dao.GoodsDao"%>
<%@page import="com.bit.vo.GoodsVo"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
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
	String path = request.getRealPath("upload");
	MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*10, "utf-8");
	String oldFname = multi.getParameter("oldFname");
	GoodsVo g = new GoodsVo();
	g.setNo(Integer.parseInt(multi.getParameter("no")));
	g.setPrice(Integer.parseInt(multi.getParameter("price")));
	g.setQty(Integer.parseInt(multi.getParameter("qty")));
	g.setName(multi.getParameter("name"));
	g.setFname(oldFname);	
	String fname = multi.getOriginalFileName("fname");
	if(fname != null) {
		g.setFname(fname);
	}
	GoodsDao dao = new GoodsDao();
	int re = dao.updateGoods(g);
	if(re>0 && fname != null) {
		File file = new File(path +"/" + oldFname);
		file.delete();
	}
	
	if(re>0) {
		response.sendRedirect("listGoods.jsp");
	}else {
		out.println("<h3>상품수정 실패</h3>");
	}
%>
</body>
</html>