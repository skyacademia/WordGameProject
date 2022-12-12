package Gameroom.Utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

	UserDTO dto = null;
	Connection conn = null;
	DBConn dbConn = new DBConn();

	public UserDAO() {
		
	}

	public void user_register(String nid, String npw) { // 회원가입
		Connection conn = dbConn.getConnection();
		try {
			String sql = "insert into user_info(id,pw,win,lose,tie) values(?,?,0,0,0);";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, nid);
			pstmt.setString(2, npw);

			pstmt.executeUpdate();
			System.out.println("good");

			dbConn.clear(conn, pstmt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public UserDTO loginCheck(String nid, String npw) { // 로그인 
		conn = dbConn.getConnection();
		UserDTO user = null;
		try {
			String sql = "select * from User_Info where id=? and pw=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nid);
			pstmt.setString(2, npw);

			ResultSet result = pstmt.executeQuery();

			while(result.next()) {
				String id = result.getString("id");
				String pw = result.getString("pw");
				int win = result.getInt("win");
				int lose = result.getInt("lose");
				int tie = result.getInt("tie");
				user = new UserDTO(id,pw,win,lose,tie);
			}
			
			
			dbConn.clear(result, conn, pstmt);
			return user;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	

	public void win(String nid) { // 승 추가 
		conn = dbConn.getConnection();
		try {
			String sql = "update user_info set win = ? where id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getWin() + 1);
			pstmt.setString(2, nid);

			pstmt.executeUpdate();


			System.out.println("good");
			dbConn.clear(conn, pstmt);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void lose(String nid) { // 패 추가 
		conn = dbConn.getConnection();
		try {
			String sql = "update user_info set lose = ? where id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getLose() + 1);

			pstmt.setString(2, nid);

			pstmt.executeUpdate();

			System.out.println("good");
			dbConn.clear(conn, pstmt);
			// 자원 해제
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void tie(String nid) { // 동점 추가 
		conn = dbConn.getConnection();
		try {
			String sql = "update user_info set tie = ? where id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getTie() + 1);
			pstmt.setString(2, nid);

			pstmt.executeUpdate();

			System.out.println("good");
			dbConn.clear(conn, pstmt);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
