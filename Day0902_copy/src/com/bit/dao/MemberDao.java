package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.bit.db.ConnectionProvider;

public class MemberDao {
	
	private static MemberDao dao;
	private MemberDao() {
		
	}
	
	public static MemberDao getInstance() {
		if(dao==null) {
			dao = new MemberDao();
		}
		return dao;
	}
	
	//없는 아이디면 -1
	//암호가 잘못되면 0
	//올바른 회원 1
	
	public int isMember(String id, String pwd) {
		int re = -1;
		String sql = "select pwd from member where id=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				String dbPwd = rs.getString(1);
					if(dbPwd.equals(pwd)) {
						re = 1;
					} else {
						re = 0;
					}
			}else {
				re = -1;
			}
		} catch (Exception e) {
			System.out.println("isMember 예외발생 " + e.getMessage());
		}
		return re;
	}
	
}
