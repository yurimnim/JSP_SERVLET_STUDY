<%@page import="com.bit.vo.ScheduleVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.bit.dao.ScheduleDAO"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<style>
td {
	border: 1px solid black;
}

table {
	border-collapse: collapse;
	width: 610px;
	font-size: 12px;
	margin-top: 15px;
}

tr{
	height: 60px;
	vertical-align: top;
}

td{
	width: 76px;
	padding: 5px;
}

h3{
	border-left: 8px solid blue;
	padding: 10px;
	
}

#day{
	height: 20px;
	background-color: #f8f9f2;
	text-align: center;
	font-weight: bold;
}

.red{
	color: red;
}

.basic{
	color: black;
}

#title{
	border: none;
	vertical-align: bottom;
	height: 10px;
}

a {
	text-decoration: none;
}
	
</style>
<title>Insert title here</title>
</head>
<body>
<%
	int []lastDay = {31,28,31,30,31,30,31,31,30,31,30,31};

	Date today = new Date();
	int year = today.getYear();
	int month = today.getMonth();
	
	if(request.getParameter("year")!=null){
		year = Integer.parseInt(request.getParameter("year"));
		month = Integer.parseInt(request.getParameter("month"));
		
		if(month >= 12){
			year++;
			month=0;
		}
		
		if( month < 0){
			year--;
			month=11;
		}
	}
		
	Date startDay = new Date(year, month, 1);
	int yoil= startDay.getDay();
	ScheduleDAO dao = new ScheduleDAO();
%>
<h3>나의 일정</h3>
<table>
	<tr>
		<td colspan='7' align='right'><a href = "Calandar3.jsp?year=<%=year%>&month=<%=month-1%>">◀</a>
		
		 <%=year+1900%>년 <%=month+1%>월
		 
		 <a href = "Calandar3.jsp?year=<%=year%>&month=<%=month+1%>"> ▶</a></td>
	</tr>
	<tr id ='day'>
		<th class ='red'>일</th>
		<th>월</th>
		<th>화</th>
		<th>수</th>
		<th>목</th>
		<th>금</th>
		<th>토</th>
	</tr>
	<tr>
	<%
			//날짜를 출력하기 전에 그달의 1일의 요일의 숫자 만큼 빈칸을 출력
			//만약 8월 1일이 토요일이면 6만큼 빈칸(아무글자가 
			//		없는  <td></td>)을 출력해야 합니다!
			for(int j=1; j<=yoil; j++){
				%>
				<td>&nbsp;</td>
				<%
			}
		
			for(int i=1;i<=lastDay[month];i++){
				String cname = "basic";
				if( (i+yoil) % 7 == 1  )
				{
					cname = "red";
				}
				%>
					<td class=<%=cname %>><%=i %><br>
					<%= dao.getSchedule(year+1900, month+1,i)%>
					</td>
				<%
				if( (i+yoil) % 7 ==0){
					%>
					</tr><tr>
					<%
				}
			}
		%>
	</tr>
</table>
</body>
</html>