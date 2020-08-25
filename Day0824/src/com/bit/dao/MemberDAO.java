package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bit.db.ConnectionProvider;

public class MemberDAO {
	
	public int isMember(String id, String pwd) {
		int re = -3;
		String sql = "select * from member where id=? and pwd=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			ResultSet rs = pstmt.executeQuery();
			
			if(id.equals(rs.getString(1))&&pwd.equals(rs.getString(2))){
				re=1;
			} else if (id.equals(rs.getString(1))&& !pwd.equals(rs.getString(2))){
				re=0;
			} else if (!id.equals(rs.getString(1))&&pwd.equals(rs.getString(2))) {
				re = -1;
			} else {
				re = -2;
			}
			
		} catch (Exception e) {
			System.out.println("isMember 예외발생 " + e.getMessage());
		}		
		return re;
	}
}