package com.bit.dao;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import com.bit.db.ConnectionProvider;

public class TestDao {
		
	private static TestDao dao;
	
	private TestDao() {
			
		}
		
		public static TestDao getInstance() {
			if(dao ==null) {
				dao = new TestDao();
			}
			return dao;
		}
		
	public void deleteTable() {
    	try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "drop table test";
			Statement stmt = conn.createStatement();
			boolean re = stmt.execute(sql);
			ConnectionProvider.close(null, stmt, conn);			
		} catch (Exception e) {
			System.out.println("contextDestroyed 예외발생 " + e.getMessage());
		}
	}
		
	public void creatTable() {		
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql = "create table test(no number primary key, title varchar2(50))";
			Statement stmt = conn.createStatement();
			stmt.execute(sql);	
			ConnectionProvider.close(null, stmt, conn);	
		} catch (Exception e) {
			System.out.println("contextInitialized 예외발생 " + e.getMessage());
		}
	}
	
	public void insertData(int no, String name) {
		try {
			Connection conn = ConnectionProvider.getConnection();
			String sql2 = "insert into test values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			pstmt.executeUpdate();
			ConnectionProvider.close(null, pstmt, conn);	
		} catch (Exception e) {
			System.out.println("contextInitialized 예외발생 " + e.getMessage());
		}
	}
		
	}


