<%@page import="com.bit.vo.EmpVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.dao.EmpDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	* {
		font-family: 'Noto Sans KR';
	}
	
	table {
		border-collapse: collapse;
	}
	
	li {
		list-style: none;
	}
</style>
<meta charset="UTF-8">
<title>직원 추가 페이지</title>
</head>
<body>
<%
	EmpDAO dao = new EmpDAO();
	ArrayList<EmpVO> list = dao.listAll(); 
%>

<h3>직원 등록 시스템</h3>
<hr> 
<form action="insertEmpOK.jsp" method="post">
<ul>
	<li>직원 번호: <input type="text" name="empno"> </li>
	<li>직원 이름:&nbsp;<input type ="text" name="ename"></li>
	<li>직책&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="job"></li>
	<li>관리자번호:&nbsp;<input type="text" name="mgr"> </li>
	<li>입사일 :**등록 당일날짜로 등록됩니다.</li>
	<li>월 급여&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;:<input type="text" name="sal"></li>
	<li>커미션&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <input type="text" name="comm"></li>
	<li>부서번호:&nbsp;&nbsp;&nbsp;: <input type="text" name="deptno"></li>
</ul>
<input type ="submit" value ="등록">
</form>
<hr> 
<h3>직원 목록</h3>
<table border ="1">
	<tr>
		<th>직원 번호</th>
		<th>직원 이름</th>
		<th>직책 </th>
		<th>관리자 번호</th>
		<th>입사일 </th>
		<th>월 급여</th>
		<th>커미션</th>
		<th>부서번호</th>
	</tr>
	
 	<%
 	 for(EmpVO e:list) {
 		 %>
 		 <tr>
	 		<td><%=e.getEmpno() %></td> 
	 		<td><a href="empDetail.jsp"><%=e.getEname() %></a></td> 
	 		<td><%=e.getJob() %></td> 
	 		<td><%=e.getMgr() %></td> 
	 		<td><%=e.getHiredate() %></td> 
	 		<td><%=e.getSal()%></td> 
	 		<td><%=e.getComm() %></td> 
	 		<td><%=e.getDeptno() %></td> 
 		</tr>
 		 <%
 	 }	
 	%>
</table>

</body>
</html>