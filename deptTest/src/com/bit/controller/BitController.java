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

import com.bit.action.BitAction;

/**
 * Servlet implementation class BitController
 */
@WebServlet("*.do")
public class BitController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	HashMap<String, BitAction> map;

    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
//		super.init(config);
    	map = new HashMap<String, BitAction>();
    	String path = 
    	config.getServletContext().getRealPath("WEB-INF");
    	try {
    		FileReader fr = new FileReader(path + "/bit.properties");
    		Properties prop = new Properties();
    		prop.load(fr);
    		Iterator keyList = prop.keySet().iterator();
    		while(keyList.hasNext()) {
    			String key = (String) keyList.next();
    			String clsName = (String)prop.get(key);
    			BitAction obj = (BitAction)Class.forName(clsName).newInstance();
    			map.put(key, obj);
    		}
    		
    	}catch (Exception e) {
    		System.out.println("예외발생:"+e.getMessage());
		}
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
		// TODO Auto-generated method stub
		proRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		proRequest(request, response);
	}

	private void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String cmd = uri.substring( uri.lastIndexOf("/")+1);
		BitAction action = map.get(cmd);
		String viewPage = action.pro(request, response);
		RequestDispatcher dispatcher
		= request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		
	}

}