package com.bit.listener;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Statement;
import java.util.StringTokenizer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.bit.dao.TestDao;
import com.bit.db.ConnectionProvider;

/**
 * Application Lifecycle Listener implementation class BitListener
 *
 */
@WebListener
public class BitListener implements ServletContextListener {

    /**
     * Default constructor. 
     */
    public BitListener() {
        
    }

	/**
     * @see ServletContextListener#contextDestroyed(ServletContextEvent)
     */
    public void contextDestroyed(ServletContextEvent sce)  { 
    	TestDao dao = TestDao.getInstance();
//    	dao.deleteTable();
        System.out.println("서버종료");
    }

	/**
     * @see ServletContextListener#contextInitialized(ServletContextEvent)
     */
    public void contextInitialized(ServletContextEvent arg0)  { 
    	TestDao dao = TestDao.getInstance();
    	dao.creatTable();
    	String path = arg0.getServletContext().getRealPath("WEB-INF");
    	try {
			BufferedReader br = new BufferedReader(new FileReader(path+"/test.txt"));
			String line;
			
			while( (line=br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(line,",");
				int no = Integer.parseInt(st.nextToken());
				String title = st.nextToken();
				dao.insertData(no, title);
			}
			br.close();
		} catch (Exception e) {
			System.out.println("contextInitialized 예외발생 " + e.getMessage());
		}
    	
//    	dao.creatTable(int no, String name);
        System.out.println("서버가동"); 	

    }
	
}
