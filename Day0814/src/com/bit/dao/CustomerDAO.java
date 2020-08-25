package com.bit.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.db.ConnectionProvider;

public class CustomerDAO {
	public ArrayList<String> listName() {
		ArrayList<String> list = new ArrayList<String>();
		String sql = "select name from customer";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(rs.getString(1));
			}
			ConnectionProvider.close(conn, stmt, rs);
 		} catch (Exception e) {
			System.out.println("dao 예외발생" + e.getMessage());
		}
		return list; 		
	}
}
