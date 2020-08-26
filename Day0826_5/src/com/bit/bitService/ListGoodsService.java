package com.bit.bitService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.dao.GoodsDao;

public class ListGoodsService implements BitService {

	@Override
	public String service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		GoodsDao dao = new GoodsDao();
		request.setAttribute("list", dao.listAll());
		return "listGoods.jsp";
	}

}
