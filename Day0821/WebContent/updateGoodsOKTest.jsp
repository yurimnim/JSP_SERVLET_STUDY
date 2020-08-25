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
	String fname = multi.getOriginalFileName("fname");
	if(fname == null) {
		System.out.println("NULL");
	} else if(fname.equals("")){
		System.out.println("EMPTY");
	}else {
		System.out.println("UPLOADED " + fname);
	}
%>
</body>
</html>