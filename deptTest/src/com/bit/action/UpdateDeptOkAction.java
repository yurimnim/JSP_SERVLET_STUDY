package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.DeptDao;
import com.bit.vo.DeptVo;

public class UpdateDeptOkAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		DeptVo d = new DeptVo();
		d.setDeptno(Integer.parseInt(request.getParameter("deptno")));
		d.setDname(request.getParameter("dname"));
		d.setLoc(request.getParameter("loc"));
		DeptDao dao = new DeptDao();
		int re=dao.updateDept(d);
		request.setAttribute("re", re);	
		return "updateDeptOk.jsp";
	}
}
