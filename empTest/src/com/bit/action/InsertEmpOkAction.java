package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.EmpDao;
import com.bit.vo.EmpVo;

public class InsertEmpOkAction implements EmpAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		EmpDao dao = EmpDao.getInstance();
		EmpVo e = new EmpVo();
		e.setEmpno(Integer.parseInt(request.getParameter("empno")));
		e.setMgr(Integer.parseInt(request.getParameter("mgr")));
		e.setSal(Integer.parseInt(request.getParameter("sal")));
		e.setComm(Integer.parseInt(request.getParameter("comm")));
		e.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		e.setEname(request.getParameter("ename"));
		e.setJob(request.getParameter("job"));
		e.setHiredate(request.getParameter("hiredate"));
		
		int re = dao.insertEmp(e);
		request.setAttribute("re", re);
		
		return "insertEmpOk.jsp";
	}

}
