<%@page import="java.io.File"%>
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
	String oldFname = dao.getGoods(no).getFname();
	int re = dao.deleteGoods(no);
	if(re > 0){
		String path = request.getRealPath("upload");
		File file = new File(path + "/" + oldFname); 
		file.delete();
		response.sendRedirect("listGoods.jsp");
	}else{
		out.print("<h3>상품삭제 오류!</h3>");
	}

%>
</body>
</html>