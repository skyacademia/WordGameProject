package Gameroom.Client.controller;

import javax.swing.JPanel;

import Gameroom.Client.MultiClient;
import Gameroom.Client.view.LobbyPanel;
import Gameroom.Client.view.LoginPanel;
import Gameroom.Client.view.MainPanel;

public class Controller {
	
	MultiClient client;
	JPanel currentPanel;
	
	
	public void enter() {
		
		currentPanel = new LoginPanel();
		MainPanel.frame.change(currentPanel); // 로그인 패널 
		
		client = new MultiClient();
		String name = "임시 이름" + (int) (Math.random() * 10); // 구분자 
		client.start(name); // 소켓 연결

	}
	public void Lobby() {
		
		currentPanel = new LobbyPanel();
		MainPanel.frame.change(currentPanel);
	
	}
	
	public void  login(String id, String pw){
		String result;
		
//		  서버로 아이디 비밀번호를 보내주고 로그인~ 
		/*
		 * 
		 * if(result == "성공") {
		 * 
		 * 
		 * 
		 * }
		 */
		
		
	}
	
	
	
}
