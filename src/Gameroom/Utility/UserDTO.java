package Gameroom.Utility;

public class UserDTO {
	private String id;
	private String pw;
	private int win;
	private int lose;
	private int tie;
	
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(String id, String pw, int win, int lose, int tie) {
		this.id = id;
		this.pw =pw;
		this.win = win;
		this.lose = lose; 
		this.tie = tie;
	}
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getWin() {
		return win;
	}
	public void setWin(int win) {
		this.win = win;
	}
	public int getLose() {
		return lose;
	}
	public void setLose(int lose) {
		this.lose = lose;
	}
	public int getTie() {
		return tie;
	}
	public void setTie(int tie) {
		this.tie = tie;
	}
}
