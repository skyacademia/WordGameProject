package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBconn {

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("드라이버로딩성공");

			String url = "jdbc:mysql://localhost:3306/wordgamedb?serverTimezone=Asia/Seoul&jdbcCompliantTruncation=false";
			String userId = "root";
			String pass = "1234";
			
			return DriverManager.getConnection(url, userId, pass);

		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩실패");

		} catch (SQLException e) {
			System.out.println("연결 실패");
		}
		return null;
	}

	private void clear(ResultSet rs, Connection conn, PreparedStatement stmt) {
		if (rs != null) {
			try {
				if (!rs.isClosed())
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		if (stmt != null) {
			try {
				if (!stmt.isClosed())
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}

	}

	private void clear(Connection conn, PreparedStatement stmt) {
		if (stmt != null) {
			try {
				if (!stmt.isClosed())
					stmt.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				stmt = null;
			}
		}
		if (conn != null) {
			try {
				if (!conn.isClosed())
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				conn = null;
			}
		}

	}

}
