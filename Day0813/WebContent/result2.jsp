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
�Է��� ������ ������ �����ϴ�. <br>
<b>�ۼ���:</b> <%= user %><br>
<b>ID:</b> <%= id %><br>
<b>email:</b> <%= email%>@<%=domain%><br>
<b>�޴���:</b> <%= phone1 %> - <%=phone2 %> - <%=phone3 %><br>
<b>������:</b> <%= title %><br>
<b>����:</b> <%= info %><br>

</body>
</html>