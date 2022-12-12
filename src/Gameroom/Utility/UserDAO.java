package Gameroom.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

	UserDTO dto = null;
	Connection conn = null;
	String url = "jdbc:mysql://localhost:3306/game_server?useSSL=false";
	String id = "root";
	String pw = "root";

	public UserDAO() {
		this.dto = new UserDTO();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			this.conn = DriverManager.getConnection(url, id, pw);
			System.out.println("Successfully Connected!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * public void create_table() { Statement stmt = null;
	 * 
	 * try { // DB와 연결된 conn 객체로부터 Statement 객체 획득. stmt = conn.createStatement();
	 * 
	 * // query 만들기 StringBuilder sb = new StringBuilder(); String sql =
	 * sb.append("create table if not exists User_Info(").append("id varchar(30),")
	 * .append("pw varchar(20),").append("win smallint,").append("lose smallint,").
	 * append("tie smallint") .append(");").toString();
	 * 
	 * // query문 날리기 stmt.execute(sql); stmt.close(); } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 */

	public void user_register(String nid, String npw) { // 회원가입
		try {
			String sql = "insert into user_info(id,pw,win,lose,tie) values(?,?,0,0,0);";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, nid);
			pstmt.setString(2, npw);

			pstmt.executeUpdate();

			pstmt.close();
			conn.close();

			System.out.println("good");

			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public UserDTO loginCheck(String nid, String npw) { // 로그인 
		try {
			String sql = "select * from User_Info where id=? and pw=?";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, nid);
			pstmt.setString(2, npw);

			ResultSet result = pstmt.executeQuery();

			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			while(result.next()) {
				String id = result.getString("id");
				String pw = result.getString("pw");
				int win = result.getInt("win");
				int lose = result.getInt("lose");
				int tie = result.getInt("tie");
				return new UserDTO(id,pw,win,lose,tie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	

	public void win(String nid) { // 승 추가 
		try {
			String sql = "update user_info set win = ? where id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getWin() + 1);
			pstmt.setString(2, nid);

			pstmt.executeUpdate();

			pstmt.close();
			System.out.println("good");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void lose(String nid) { // 패 추가 
		try {
			String sql = "update user_info set lose = ? where id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getLose() + 1);

			pstmt.setString(2, nid);

			pstmt.executeUpdate();

			pstmt.close();
			System.out.println("good");

			// 자원 해제
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void tie(String nid) { // 동점 추가 
		try {
			String sql = "update user_info set tie = ? where id = ?;";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, dto.getTie() + 1);
			pstmt.setString(2, nid);

			pstmt.executeUpdate();

			pstmt.close();
			System.out.println("good");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
