package Gameroom.Client.controller;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Gameroom.Client.MultiClient;
import Gameroom.Client.model.ClientModel;
import Gameroom.Client.view.*;

public class Controller {

	MultiClient client;
	MainFrame mainFrame;
	LoginPanel loginPanel;
	RegisterPanel registerPanel;
	LobbyPanel lobbyPanel;
	MainPanel mainPanel;
	MakeGamePanel makeGamePanel;
	UserInfoFrame userInfoFrame;
	ClientModel model;
	

	public Controller(MainFrame mainFrame, LoginPanel loginPanel, RegisterPanel ragisterPanel, LobbyPanel lobbyPanel, MainPanel mainPanel,
			MakeGamePanel makeGamePanel, UserInfoFrame userInfoFrame,ClientModel model) {
		this.mainFrame = mainFrame;
		this.loginPanel = loginPanel;
		this.registerPanel = ragisterPanel;
		this.lobbyPanel = lobbyPanel;
		this.mainPanel = mainPanel;
		this.makeGamePanel = makeGamePanel;
		this.userInfoFrame = userInfoFrame;
		this.model = model;
		setMainPanel();
		makeMainPanelEvent();
		makeRegisterEvent();
		makeLoginEvent();
	}

	public void setMainPanel() {
		mainFrame.change(mainPanel);
	}

	public void makeMainPanelEvent() {
		mainPanel.mainPanelAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.change(loginPanel);
			}
		});
	}
	
	public void makeRegisterEvent() {
		loginPanel.registerAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainFrame.change(registerPanel);
			}
		});
	}
	
	public void makeLoginEvent() {
		loginPanel.loginAction(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> list=loginPanel.getIdPw();
				model.login(list.get(0), list.get(1));
			}
		});
	}

//	public void enter() {
//
//		loginPanel = new LoginPanel();
//		MainPanel.frame.change(currentPanel); // 로그인 패널
//
//		client = new MultiClient();
//		String name = "임시 이름" + (int) (Math.random() * 10); // 구분자
//		client.start(name); // 소켓 연결
//	}
//
//	public void Lobby() {
//
//		currentPanel = new LobbyPanel();
//		MainPanel.frame.change(currentPanel);
//
//	}

//	public void login(String id, String pw) {
//		String result;
//
////		  서버로 아이디 비밀번호를 보내주고 로그인~ 
//		/*
//		 * 
//		 * if(result == "성공") {
//		 * 
//		 * 
//		 * 
//		 * }
//		 */
//
//	}

}
