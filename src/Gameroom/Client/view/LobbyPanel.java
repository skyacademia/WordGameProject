package Gameroom.Client.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LobbyPanel extends JPanel{
	private JList userList;
	JButton enterBtn;
	JButton sendBtn;
	JTextField msginput;
	DefaultListModel<String> onUserModel;

	public LobbyPanel() {
		setLayout(new BorderLayout());
		enterMenu();
		enterChat();
	}

	private void enterMenu() {
		JPanel enterPan = new JPanel();
		JLabel title = new JLabel("끝말잇기 게임에 오신것을 환영!");

		enterPan.add(title);
		add(enterPan, "North"); // 위에 붙임 


	}
	
	private void enterChat() { // 채팅장 ui
		
		JList chatuserList = new JList(); // 대기실 채팅 유저리스트 + 모델 추가 해야함 
		chatuserList.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		chatuserList.setFocusable(false);
		JScrollPane chatListPane = new JScrollPane(chatuserList); // 스크롤 
		chatListPane.setPreferredSize(new Dimension(200, 500)); // 원하는 길이 지정
		chatListPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 항상 스크롤바가 세로로 떠있음
		
		
		
		JTextArea output  = new JTextArea(); // 보여지는 부분
		output.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		output.setEditable(false);
		JScrollPane scroll = new JScrollPane(output);
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); // 항상 스크롤바가 세로로 떠있음

		
		msginput = new JTextField(); // 메세지를 작성하는 부분
		
		sendBtn = new JButton("보내기");
		enterBtn = new JButton("빠른 시작");
		
		JPanel chatPen = new JPanel(); // 프래임에 붙일 채팅부분 패널 
		JPanel chatPenbtm = new JPanel(); // 밑에붙일 패널
		
		chatPen.setLayout(new BorderLayout());
		chatPenbtm.setLayout(new BorderLayout());
		
		chatPenbtm.add("Center", msginput); // 센터에 붙이기
		chatPenbtm.add("East", sendBtn); // 동쪽에 붙이기
		chatPenbtm.add("South", enterBtn); // 남쪽에 붙이기
		
		chatPen.add("Center", scroll); // 센터에 붙이기
		chatPen.add("South", chatPenbtm); // 남쪽에 붙이기
		chatPen.add("East", chatListPane); // 남쪽에 붙이기
		
		add(chatPen, "Center"); // 가운데에 붙임 

	}
	
	public void startFind(ActionListener listener) { // 게임 시작 
		enterBtn.addActionListener(listener);
	}
	public void sendMsg(ActionListener listener) { // 게임 시작 
		sendBtn.addActionListener(listener);
	}
	
	public String getMsg() {
		return msginput.getText();
	}

	public DefaultListModel<String> getOnUserModel() {
		return onUserModel;
	}

	public void setOnUserModel(DefaultListModel<String> onUserModel) {
		this.onUserModel = onUserModel;
	}
	
	
}