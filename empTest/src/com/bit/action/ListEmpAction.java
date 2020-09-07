package com.bit.action;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.bit.dao.EmpDao;

public class ListEmpAction implements EmpAction {
	
	public static int pageSize = 3;
	public static int totalRecord = 0;
	public static int totalPage = 1;
	public static int pageMax = 5;
	
	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");
		EmpDao dao = EmpDao.getInstance();
		String search = "";
		String option = "";
		String op = "";
		String sort = "";
		
		//정렬기능추가 
		if(request.getSession().getAttribute("sort") != null) {
			request.getSession().getAttribute("sort");
		}
		
		if(request.getParameter("sort") != null) {
			sort = request.getParameter("sort");
			session.setAttribute("sort", sort);
		}	
		
		//검색기능 추가 		
		if(request.getSession().getAttribute("search") != null) {
			search = (String)session.getAttribute("search");
			option = (String)session.getAttribute("option");
			if(option.equals("sal")) {
				 op = (String)session.getAttribute("op");
			}
		}
		

		//검색기능 상태유지 
		if(request.getParameter("search") != null) {
			search = request.getParameter("search");
			option = request.getParameter("option");
			session.setAttribute("search", search);
			session.setAttribute("option", option);
			
			//급여검색조건
			if(option.equals("sal")) {
				op = request.getParameter("op");
				session.setAttribute("op", op);
			}		
		}
		
		//페이징 처리 
		totalRecord = dao.countTotal(search, option, op);
		totalPage = (int)Math.ceil( (double)totalRecord/pageSize);
		
		int pageNUM = 1;
		if(request.getParameter("pageNUM")!=null) {
			pageNUM = Integer.parseInt(request.getParameter("pageNUM"));
		}
		
		//System.out.println("pageNUM:"+pageNUM);
		//System.out.println("totalpage : " + totalPage);

		int startPage = (pageNUM-1)/pageMax*pageMax+1;
		int endPage = startPage + (pageMax-1);
		
		if(endPage > totalPage) {
			endPage = totalPage;
		}

		String pageStr = "";
		
		if(startPage>1) {
			pageStr +=  "<a href='listEmp.do?pageNUM="+(startPage-1) +"'>"  + "이전" + "</a> ";
		}
		
		for(int i=startPage; i<= endPage; i++) {
			pageStr +=  "<a href='listEmp.do?pageNUM="+i+"'>"  + i + "</a> ";
		}
				
		if(totalPage>endPage) {
			pageStr +=  "<a href='listEmp.do?pageNUM="+(endPage+1) +"'>"  + "다음" + "</a> ";
		}
		
		
		//보내기
		request.setAttribute("list", dao.listAll(pageNUM,search, option,op,sort));
		request.setAttribute("totalPage", totalPage);
		request.setAttribute("pageStr", pageStr);

		
		return "listEmp.jsp";
	}
}
