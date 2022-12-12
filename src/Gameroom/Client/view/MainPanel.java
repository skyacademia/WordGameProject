<<<<<<< HEAD
package Gameroom.Client.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import Gameroom.Client.controller.Controller;

public class MainPanel extends JPanel {
	JButton btn_enter;

	public MainPanel() {
		setLayout(null);
		setBounds(0, 70, 300, 300);

		JLabel hellolabel = new JLabel("끝말잇기 게임 메인입니다");
		hellolabel.setBounds(10, 30, 300, 22);
		add(hellolabel);

		btn_enter = new JButton("입장하기");
		btn_enter.setBounds(70, 40, 150, 100);
		add(btn_enter);
	}

	// 입장하기 버튼
	public void mainPanelAction(ActionListener listener){
		this.btn_enter.addActionListener(listener);
	}
}

=======
package Gameroom.Client.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import Gameroom.Client.controller.Controller;

public class MainPanel extends JPanel {
	JButton btn_enter;

	public MainPanel() {
		setLayout(null);
		setBounds(0, 70, 300, 300);

		JLabel hellolabel = new JLabel("끝말잇기 게임 메인입니다");
		hellolabel.setBounds(10, 30, 300, 22);
		add(hellolabel);

		btn_enter = new JButton("입장하기");
		btn_enter.setBounds(70, 40, 150, 100);
		add(btn_enter);
	}

	// 입장하기 버튼
	public void mainPanelAction(ActionListener listener){
		this.btn_enter.addActionListener(listener);
	}
}

>>>>>>> branch 'main' of https://github.com/skyacademia/WordGameProject.git
