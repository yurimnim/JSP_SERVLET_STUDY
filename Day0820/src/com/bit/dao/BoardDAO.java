package com.bit.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.bit.db.ConnectionProvider;
import com.bit.vo.BoardVO;

public class BoardDAO {		
	public int deleteBoard(int no) {
		int re = -1;
		String sql = "delete board where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		} catch (Exception e) {
			System.out.println("deleteBoard 예외발생 " + e.getMessage());
		}	
		return re;
	}
	
	public int updateBoard(BoardVO b) {
		int re = -1;
		String sql = "update board set title=?,content=? where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getContent());
			pstmt.setInt(3, b.getNo());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		} catch (Exception e) {
			System.out.println("updateBoard 예외발생 " + e.getMessage());
		}
		return re;
	}
		
	public void updateHit(int no) {
		String sql = "update board set hit=hit+1 where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, no);
			pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		} catch (Exception e) {
			System.out.println("updateBoard 예외발생 " + e.getMessage());
		}
	}
	
	public BoardVO getBoard(int no, boolean hitAdd) {
		BoardVO b = null;
		if(hitAdd) {
			updateHit(no);
		}		
		String sql ="select no,title,writer,regdate,content,hit,ip from board where no=?";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);		
			pstmt.setInt(1, no);
			ResultSet rs = pstmt.executeQuery();      
			if(rs.next()) {
				b=new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getString(7));
			}
			ConnectionProvider.close(conn, pstmt, rs);	
		} catch (Exception e) {
			System.out.println("getBoard 예외발생 " + e.getMessage());
		}		
		return b;
	}
	
	public ArrayList<BoardVO> listAll() {
		String sql="select * from board order by no desc";
		ArrayList<BoardVO> list = new ArrayList<BoardVO>();
		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()) {
				list.add(new BoardVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getDate(4), rs.getString(5), rs.getInt(6), rs.getString(7)));
			}
			ConnectionProvider.close(conn, stmt, rs);			
		} catch (Exception e) {
			System.out.println("listAll 예외발생 " + e.getMessage());
		}		
		return list;
	}

	public int insertBoard(BoardVO b) {
		int re = -1;
		String sql = "insert into board(no, title, writer, regdate, content, hit, ip) values(seq_board.nextval,?,?,sysdate,?,0,?)";
		try {
			Connection conn = ConnectionProvider.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, b.getTitle());
			pstmt.setString(2, b.getWriter());
			pstmt.setString(3, b.getContent());
			pstmt.setString(4, b.getIp());
			re = pstmt.executeUpdate();
			ConnectionProvider.close(conn, pstmt, null);
		} catch (Exception e) {
			System.out.println("insertBoard 예외발생 " + e.getMessage());
		}
		return re;
	}		
}
