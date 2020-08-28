package com.bit.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.GoodsDao;

public class UpdateGoodsService implements BitService {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int no = Integer.parseInt(request.getParameter("no"));
		GoodsDao dao =new GoodsDao();
		request.setAttribute("g", dao.getGoods(no));
 		return "updateGoods.jsp";
	}
}
