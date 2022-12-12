package Gameroom.Client.model;

import java.net.Socket;

import Gameroom.Server.GameRoom;

public class UserDTO {
	
	private int key; // user unique id
	private String id, pw; // login id pw
	private int win, lose, tie;  // game result
	private GameRoom room; 	// playing gameroom 
	private Socket userSock; // socket 
	
	
	public UserDTO() {
		// TODO Auto-generated constructor stub
	}

	public GameRoom getRoom() {
		return room;
	}

	public void setRoom(GameRoom room) {
		this.room = room;
	}

	public Socket getUserSock() {
		return userSock;
	}

	public void setUserSock(Socket userSock) {
		this.userSock = userSock;
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
