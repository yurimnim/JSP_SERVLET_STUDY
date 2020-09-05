package com.bit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ConnectionProvider {
	
  public static void close(ResultSet rs, Statement stmt, Connection conn ) {
	  try {
		if(rs != null) {
			rs.close();
		}
		if(stmt != null) {
			stmt.close();		
		}
		if(conn != null) {
			conn.close();
		}
	} catch (Exception e) {
		System.out.println("close exception occured " + e.getMessage());
	}
  }
  
  public static Connection getConnection() {
	  Connection conn = null;
	  try {
		Class.forName("oracle.jdbc.OracleDriver");
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","oracle");
	} catch (Exception e) {
		System.out.println("Connection exception occured " +e.getMessage());
	}
	  return conn;
  }
}
