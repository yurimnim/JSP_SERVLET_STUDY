package com.bit.controller;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.bitService.BitService;
import com.bit.bitService.DetailGoodsService;
import com.bit.bitService.ListGoodsService;

/**
 * Servlet implementation class BitController
 */
//@WebServlet("/BitController")
public class BitController extends HttpServlet {
	HashMap<String, BitService> map;
	
	private static final long serialVersionUID = 1L;
    
	@Override
		public void init(ServletConfig config) throws ServletException {
		
		map = new HashMap<String,BitService>();
		map.put("listGoods.do", new ListGoodsService());
		map.put("detailGoods.do", new DetailGoodsService());
	}
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BitController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proRequest(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proRequest(request,response);
	}

	private void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String uri = request.getRequestURI();
		System.out.println("uri:"+uri);	
		String cmd = uri.substring(uri.lastIndexOf("/")+1);
		System.out.println("cmd:"+cmd);
		
		BitService bs = null;
		bs = map.get(cmd);
		
		String view= bs.service(request, response);
		RequestDispatcher dispatcher
		= request.getRequestDispatcher(view);
		dispatcher.forward(request, response);
		
	}

}

