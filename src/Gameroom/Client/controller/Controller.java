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
				mainFrame.change(lobbyPanel);
			}
		});
	}
	
	public void findUserEvent() {
		lobbyPanel.startFind(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.findgame();
			}
		});
	}
	public void sendMsgEvent() {
		lobbyPanel.sendMsg(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				model.sendMsg(lobbyPanel.getMsg());
				
				
			}
		});
	}


}
