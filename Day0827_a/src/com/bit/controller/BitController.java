package com.bit.controller;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit.service.BitService;
import com.bit.service.DetailGoodsService;
import com.bit.service.InsertGoodsService;
import com.bit.service.InsertGoodsServiseOK;
import com.bit.service.ListGoodsService;

/**
 * Servlet implementation class BitController
 */
@WebServlet("*.do")
public class BitController extends HttpServlet {
	HashMap<String, BitService> map;
	
	private static final long serialVersionUID = 1L;
    
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//super.init(config);
    	map = new HashMap<String, BitService>();
    	String path = config.getServletContext().getRealPath("WEB-INF");
    	System.out.println(path);
    	try {
    		FileReader fr = new FileReader(path + "/bit.properties");
    		Properties prop = new Properties();
    		prop.load(fr);
    		Iterator keyList = prop.keySet().iterator();
    		while(keyList.hasNext()) {
    			String key = (String)keyList.next();    			
    			String clsName= (String)prop.get(key);
    			BitService obj = 
    			 (BitService)Class.forName(clsName).newInstance();
    			
    			map.put(key, obj);
    		}
    		
    	}catch (Exception e) {
    		System.out.println("예외발생:"+e.getMessage());
		}
  
    }
	
				

//		map.put("listGoods.do", new ListGoodsService());
//		map.put("detailGoods.do", new DetailGoodsService());
//		map.put("insertGoods.do", new InsertGoodsService());
//		map.put("insertGoodsOK.do", new InsertGoodsServiseOK());
	
	
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

