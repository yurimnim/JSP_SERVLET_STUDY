package com.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.bit.action.ListBoardAction;
import com.bit.db.ConnectionProvider;
import com.bit.vo.BoardVo;

public class BoardDao {
	

	//검색어에 따른 레코드 수를 반환하도록 고치자 
	public int getTotalCount(String search, String option) {
		int n = 0;
		String sql = "select count(*) from board ";
		
		if(!search.equals("")) {
			sql+= "where " + option + " like '%" + search + "%'";
		}
				
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				n = rs.getInt(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("getTotalRecord 예외발생 " + e.getMessage());
		}
		return n;		
	}
	
	public void updateStep(int b_ref, int b_step) {
		String sql = "update board set b_step=b_step+1 where b_ref=? and b_step>?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_ref);
			pstmt.setInt(2, b_step);
			pstmt.executeUpdate();
			ConnectionProvider.close(null, pstmt, conn);
		} catch (Exception e) {
			System.out.println("updateStep 예외발생 " + e.getMessage());
		}
	}
	
	public int getNextNo() {
		int n = 0;
		//기존에 있는 글번호 중에 가장 큰 값에 더하기 1을 하여 반환하고 싶다. 
		String sql = "select nvl(max(no),0)+1 from board";
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()) {
				n = rs.getInt(1);
			}
			ConnectionProvider.close(rs, stmt, conn);
		} catch (Exception e) {
			System.out.println("getNextNo 예외발생 " + e.getMessage());
		}
		return n;
	}
	
	
	 public BoardVo getBoards(int no) {
		 BoardVo b = null;
		 try {
			String sql = "select * from board where no=?";
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,no);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				b = new BoardVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
								rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10));
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			System.out.println("getBoards 예외발생 " + e.getMessage());
		}
		 return b;
	 }
	
	
	public ArrayList<BoardVo> listAll(int pageNUM, String search, String option, String sort, String cnt) {		
		ArrayList<BoardVo> list = new ArrayList<BoardVo>();
		
		int end = pageNUM*ListBoardAction.pageSize;
		int start = end - (ListBoardAction.pageSize-1);

//		 String sql = "select no, title, writer, pwd, content, regdate, hit, b_ref, b_level, b_step from"
//			 		+ "(select rownum n, no, title, writer, pwd, content, regdate, hit, b_ref, b_level, b_step "
//			 		+ "from(select * from board order by b_ref DESC,b_step)) "
//			 		+ "where n>=? and n<=?";
	
//		String sql = "select no, title, writer, pwd, content, regdate, hit, b_ref, b_level, b_step " + 
//				"from (select rownum n, no, title, writer, pwd, content, regdate, hit, b_ref, b_level, b_step " + 
//				"from (select * from board where "+option+" like '%"+search+"%')) " + 
//				"where n>=? and n<=?";
			
		String sql = "select no,title,writer,pwd,content," + 
				"regdate,hit,b_ref,b_level,b_step from (select rownum n, no,title,writer,pwd,content," + 
				"regdate,hit,b_ref,b_level,b_step from " + 
				"	(select  * from board ";
				
				if(!search.equals("")) {
					sql += "where "+option+" like '%"+search+"%' ";
				}
			
				if(!sort.equals("")) {
					sql += "order by "+ sort + " " + cnt;
				}	
				
				sql += ")) " + "where n >= ? and n <= ?";	

		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new BoardVo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDate(6), rs.getInt(7), rs.getInt(8), rs.getInt(9), rs.getInt(10)));
			}
			ConnectionProvider.close(rs, pstmt, conn);
		} catch (Exception e) {
			System.out.println("list All exception: " + e.getMessage());
		}
		return list;
	}
	
	public int insertBoard(BoardVo b) {
		int re = -1;
		String sql = "insert into board values(?,?,?,?,?,sysdate,0,?,?,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b.getNo());
			pstmt.setString(2, b.getTitle());
			pstmt.setString(3, b.getWriter());
			pstmt.setString(4, b.getPwd());
			pstmt.setString(5, b.getContent());
			pstmt.setInt(6, b.getB_ref());
			pstmt.setInt(7, b.getB_level());
			pstmt.setInt(8, b.getB_step());
			
			re = pstmt.executeUpdate();
			
			ConnectionProvider.close(null, pstmt, conn);
			
		} catch (Exception e) {
			System.out.println("insertBoard exception occured: " + e.getMessage());
		}
		
		return re;
		
	}
	
	public void updateHit(int no) {
		 String sql = "update board set hit=hit+1 where no=?";
		 //게시물중에 이미 달려있는 답글이 있다면 b_step을 1씩 증가 
		 try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			ConnectionProvider.close(null, pstmt, conn);
		} catch (Exception e) {
			System.out.println("updateHit 예외발생 " + e.getMessage());
		}
	 }
}
