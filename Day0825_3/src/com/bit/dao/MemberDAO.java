package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bit.db.ConnectionProvider;

public class MemberDAO {
	
	public boolean isMember(String id, String pwd) {
		boolean re = false;
		String sql = "select * from member where id=? and pwd=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				re = true;
			}
			ConnectionProvider.close(conn, pstmt, rs);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("예외발생:"+e.getMessage());
		}
		return re;
	}
}