<%@page import="com.bit.dao.EmpDAO"%>
<%@page import="com.bit.vo.EmpVO"%>
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
	EmpVO b = new EmpVO();
	b.setEmpno(Integer.parseInt(request.getParameter("empno")));
	b.setEname(request.getParameter("ename"));
	b.setJob(request.getParameter("job"));
	b.setMgr(Integer.parseInt(request.getParameter("mgr")));
	b.setSal(Integer.parseInt(request.getParameter("sal")));
	b.setComm(Integer.parseInt(request.getParameter("comm")));
	b.setDeptno(Integer.parseInt(request.getParameter("deptno")));
	EmpDAO dao = new EmpDAO();
	int re= dao.insertEmp(b);
		if(re>0) {
			response.sendRedirect("insertEmp.jsp");
		}else {
			out.print("<h3>직원 등록 오류.</h3>");
		}
%>
</body>
</html>