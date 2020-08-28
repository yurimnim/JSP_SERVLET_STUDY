package com.bit.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.DeptDao;

public class ListDeptAction implements BitAction {

	@Override
	public String pro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DeptDao dao = new DeptDao();
		request.setAttribute("list", dao.listAll());
		return "listDept.jsp";
	}

}
