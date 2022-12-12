package Gameroom.Utility;

import java.io.Serializable;

public class UserDTO implements Serializable {

	private String id;
	private String pw;
	private int win;
	private int lose;
	private int tie;
	private int state; 
	
	/* state 
	 * 0 : 대기중 (초기값)
	 * 1 : 게임찾는중
	 * 2 : 게임중 
	 * */
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}
	
	public UserDTO(String id, String pw, int win, int lose, int tie) {
		this.id = id;
		this.pw =pw;
		this.win = win;
		this.lose = lose; 
		this.tie = tie;
		state = 0;
	}

	public String getId() {
		return id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
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
