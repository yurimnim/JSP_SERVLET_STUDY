package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.DeptDao;

public class DeleteDeptAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int deptno = Integer.parseInt(request.getParameter("deptno"));
		DeptDao dao = new DeptDao();
		int re =dao.deleteDept(deptno);
		request.setAttribute("re", re);
		return "deleteDeptOk.jsp";
	}
}
