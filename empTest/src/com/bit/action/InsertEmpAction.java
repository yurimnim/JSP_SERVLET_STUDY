package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.EmpDao;
import com.bit.vo.EmpVo;

public class InsertEmpAction implements EmpAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		EmpDao dao = EmpDao.getInstance();
		request.setAttribute("list", dao.listEmp());
		request.setAttribute("dlist", dao.listDept());
		request.setAttribute("newEmpno", dao.getNewEmpno());
		
		return "insertEmp.jsp";
	}

}
