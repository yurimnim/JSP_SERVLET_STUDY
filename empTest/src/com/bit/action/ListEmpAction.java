package com.bit.action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.bit.dao.EmpDao;

public class ListEmpAction implements EmpAction {
	
	public static int pageSize = 3;
	public static int totalRecord = 0;
	public static int totalPage = 1;
	public static int pageMax = 5;
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pageNUM = 1;
		if(request.getParameter("pageNUM")!=null) {
			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));
		}
		
		System.out.println("pageNUM:"+pageNUM);
		
		EmpDao dao = EmpDao.getInstance();
		totalRecord = dao.countTotal();
		totalPage = (int)Math.ceil( (double)totalRecord/pageSize);
		
		request.setAttribute("list", dao.listAll(pageNUM));
		request.setAttribute("totalPage", totalPage);
		
		int startPage = (pageNUM-1)/pageMax*pageMax+1;
		int endPage = startPage + (pageMax-1);
		
		
		String pageStr = "";
		for(int i=startPage; i<= endPage; i++) {
			pageStr +=  "<a href='listEmp.do?pageNUM="+i+"'>"  + i + "</a> ";
		}
		
		request.setAttribute("pageStr", pageStr);
		
		return "listEmp.jsp";
	}
}
