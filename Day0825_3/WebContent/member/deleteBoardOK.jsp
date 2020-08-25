<%@page import="java.io.File"%>
<%@page import="com.bit.dao.BoardDAO"%>
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
	String pwd = request.getParameter("pwd");
	BoardDAO dao = new BoardDAO();
	String oldFname = dao.getBoard(no,false).getFname();
	
	int re = dao.deleteBoard(no,pwd);
	
	if (re>0 && oldFname != null && oldFname.equals("") && oldFname.equals("null")) {
		String path = request.getRealPath("upload");
		File file = new File(path + "/" + oldFname);
		file.delete();		
	}
	if(re > 0) {
		response.sendRedirect("listBoard.jsp");
	} else {
		%>
		삭제에 실패하였습니다.<br>
		<a href="member/listBoard.jsp">글목록</a>
		<%
	}	
%>

</body>
</html>