<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="java.io.File"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="com.bit.dao.BoardDAO"%>
<%@page import="com.bit.vo.BoardVO"%>
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
	String path =request.getRealPath("upload");
	
	//MultipartRequest multi = new MultipartRequest(request,path,1024*1024*10,"utf-8");
	MultipartRequest multi = new MultipartRequest(request, path, 1024*1024*10,"utf-8", new DefaultFileRenamePolicy());
	String oldFname = multi.getParameter("oldFname");
	
	BoardVO b = new BoardVO();
	b.setNo(Integer.parseInt(multi.getParameter("no")));
	b.setTitle(multi.getParameter("title"));
	b.setContent(multi.getParameter("content"));
	b.setFname(oldFname);
	String fname = multi.getOriginalFileName("fname");
	b.setPwd(multi.getParameter("pwd"));
	if(fname != null){
		b.setFname(fname);
	}
	
	BoardDAO dao = new BoardDAO();
	int re = dao.updateBoard(b);
	if(re >0 && fname != null && oldFname != null && !oldFname.equals("") && !oldFname.equals("null")){
		File file = new File(path + "/" + oldFname);
		file.delete();
	}
	
	if(re > 0){
		response.sendRedirect("listBoard.jsp");
	}else{
		%>
		수정에 실패하였습니다.<br>
		<a href="listBoard.jsp">글목록</a>
		<%
	}
		
%>
</body>
</html>