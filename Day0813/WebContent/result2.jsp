<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	request.setCharacterEncoding("euc-kr");
	String user = request.getParameter("user");
	String id = request.getParameter("id");
	String email = request.getParameter("email");
	String domain = request.getParameter("domain");
	String phone1 = request.getParameter("phone1");
	String phone2 = request.getParameter("phone2");
	String phone3 = request.getParameter("phone3");
	String title = request.getParameter("title");
	String info = request.getParameter("info");
%>
입력한 정보는 다음과 같습니다. <br>
<b>작성자:</b> <%= user %><br>
<b>ID:</b> <%= id %><br>
<b>email:</b> <%= email%>@<%=domain%><br>
<b>휴대폰:</b> <%= phone1 %> - <%=phone2 %> - <%=phone3 %><br>
<b>글제목:</b> <%= title %><br>
<b>내용:</b> <%= info %><br>

</body>
</html>