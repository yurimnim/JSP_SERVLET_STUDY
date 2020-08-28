package com.bit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionProvider {
	
	public static void close(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
			}
			if(stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}		
		} catch (Exception e) {
			System.out.println("conn close 예외발생 " + e.getMessage());			
		}		
	}
	
	
	public static Connection getConnection() {		
		Connection conn = null;
		String user = "c##madang";
		String pwd = "madang";
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@192.168.0.49:1521:X";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pwd);
		} catch (Exception e) {
			System.out.println("getConnection 예외발생 "+e.getMessage());
		}
		return conn;
	}
}
