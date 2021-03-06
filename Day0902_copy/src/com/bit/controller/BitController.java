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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BitController() {
        super();     
    }

	@Override
	public void init(ServletConfig config) throws ServletException {
		map = new HashMap<String, BitAction>();
		String path = config.getServletContext().getRealPath("WEB-INF");
		try {
			FileReader fr = new FileReader(path + "/bit.properties");
			Properties prop = new Properties();
			prop.load(fr);
			Iterator keyList = prop.keySet().iterator();
			
			while(keyList.hasNext()) {
				String key = (String)keyList.next();
				String clsName = (String)prop.get(key);
				BitAction obj = (BitAction)Class.forName(clsName).newInstance();
				map.put(key, obj);				
			}
			fr.close();
		} catch (Exception e) {
			System.out.println("init exception: " + e.getMessage());			
		}
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
	
	private void proRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		/*
		  /member/listBoard.do
		 */
		
	//	String cmd = uri.substring(uri.lastIndexOf("/") + 1);
		String cmd = uri.substring(uri.indexOf("/",1)+1);
		BitAction action = map.get(cmd);
		String viewPage = action.pro(request, response);
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
