package Gameroom.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

<<<<<<< HEAD
	Connection conn = null;
	private PreparedStatement pstmt;
	private ResultSet rs; // ResultSet : 어떠한 정보를 담을 수 있는 객체 
	
	public UserDAO() {
		try {
			String dbURL = "jdbc:mysql://localhost:3306/game_server"; // localhost:3306 : 우리 서버에 설치된 mysql을 의미, /BBS : mysql안의 BBS라는 데이터 베이스에 접속할 수 있도록 함.
			String dbID = "root"; // dbID = "root" : root 계정에 접근할 수 있도록 함
			String dbPassword = "1234"; // 패스워드나 ID를 다르게 입력하면 정상적으로 DB에 접속할 수 없음
			Class.forName("com.mysql.cj.jdbc.Driver"); // Class.forName : mysql driver를 찾을 수 있도록 함 *Driver : mysql에 접속할 수 있도록 매개체 역할을 해주는 하나의 라이브러리 
			conn = DriverManager.getConnection(dbURL, dbID, dbPassword); //conn : getConnection(db URL, dbID, dbPassword)를 이용하여 DB에 접속하고 접속이 완료가 되면 conn 객체안에 접속된 정보가 담긴다
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 

	public UserDTO login(String userID, String userPassword) { // 어떤 계정에 대한 실제로 로그인을 시도하는 함수, 인자값으로 ID와 Password를 받아 login을 판단함.
		String SQL = "SELECT * FROM user_info WHERE id = ? and pw=? "; // 실제로 DB에 입력될 명령어를 SQL 문장으로 만듬.
		UserDTO user = new UserDTO();
		try {
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1,  userID);
			pstmt.setString(2,  userPassword);
			rs = pstmt.executeQuery(); // 어떠한 결과를 받아오는 ResultSet 타입의 rs 변수에 쿼리문을 실행한 결과를 넣어줌 
			while(rs.next()) {
				user.setId(rs.getString(1));
				user.setPw(rs.getString(2));
				user.setWin(rs.getInt(3));
				user.setLose(rs.getInt(4));
				user.setTie(rs.getInt(5));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void create_table() {
		Statement stmt = null;

		try {
			// DB와 연결된 conn 객체로부터 Statement 객체 획득.
			stmt = conn.createStatement();

			// query 만들기
			StringBuilder sb = new StringBuilder();
			String sql = sb.append("create table if not exists User_Info(").append("id varchar(30),")
					.append("pw varchar(20),").append("win smallint,").append("lose smallint,").append("tie smallint")
					.append(");").toString();

			// query문 날리기
			stmt.execute(sql);
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

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

	public String[] loginCheck(String nid, String npw) { // 로그인 
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
				String win = Integer.toString(result.getInt("win"));
				String lose = Integer.toString(result.getInt("lose"));
				String tie = Integer.toString(result.getInt("tie"));
				return new String[]{id,pw,win,lose,tie};
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

=======
	UserDTO dto = null;
	Connection conn = null;
	DBConn dbConn = new DBConn();

	public UserDAO() {
		
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
		this.conn = dbConn.getConnection();
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
				return new UserDTO(id,pw,win,lose,tie);
			}
			
			
			dbConn.clear(result, conn, pstmt);
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
>>>>>>> branch 'main' of https://github.com/skyacademia/WordGameProject.git
			pstmt.setString(2, nid);

			pstmt.executeUpdate();

			pstmt.close();
			System.out.println("good");

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
