package Gameroom.Client.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Gameroom.Client.controller.Controller;

public class MainPanel extends JPanel {
	public static MainFrame frame;
	Controller ctl;
	JButton btn_enter;

	public MainPanel(MainFrame frame) {

		MainPanel.frame = frame;
		setLayout(null);
		setBounds(0, 70, 300, 300);
		showLogo();
		setEnterButton();

	}

	private void setEnterButton() { // 입장하기 버튼
		
		btn_enter = new JButton("입장하기");
		btn_enter.setBounds(70, 40, 150, 100);
		btn_enter.addActionListener(e->{
			ctl = new Controller();
			ctl.enter(); // 실행 
		});

		add(btn_enter);
	}

	private void showLogo() {

		JLabel hellolabel = new JLabel("끝말잇기 게임 메인입니다");
		hellolabel.setBounds(10, 30, 300, 22);
		add(hellolabel);
	}
	
	

	
}
