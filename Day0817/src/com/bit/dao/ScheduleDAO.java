package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.bit.db.ConnectionProvider;

public class ScheduleDAO {
	
	public String getSchedule(int year, int month, int day) {
		String r = "";
		String sql = "select * from schedule where year=? and month=? and day=?";	
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, year);
			pstmt.setInt(2, month);
			pstmt.setInt(3, day);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				r=rs.getString(5);
			}
			ConnectionProvider.close(conn, pstmt, rs);
		} catch (Exception e) {
			System.out.println("getSchedule 예외발생 " + e.getMessage());			
		} 	
		return r;
	}
}
