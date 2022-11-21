package client.frame;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.MultiClient;

public class MainPanel extends JPanel {
	public static MainFrame frame;
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

		add(btn_enter);
	}

	private void showLogo() {

		JLabel hellolabel = new JLabel("끝말잇기 게임입니다..(로고같은거 넣어도 될거같고요...");
		hellolabel.setBounds(10, 30, 300, 22);
		add(hellolabel);
	}
	
	
	
	public void Action01(ActionListener listener) {
		btn_enter.addActionListener(listener);
	}
	
	
}


