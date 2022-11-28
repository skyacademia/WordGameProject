package Gameroom.Client.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gameroom.Client.controller.Controller;

public class LoginPanel extends JPanel {

	
	Controller ctl;
// 로그인 라벨 필드 
	JLabel label_loginid;
	JTextField input_id;
	JLabel label_loginpw;
	JTextField input_pw;

	// 로그인 버튼, 가입버튼
	JButton btn_logindo;
	JButton btn_joindo;
	
	

	public LoginPanel() {
		setLayout(null);
		loginform();
		setButtons();
	}

	private void loginform() {

		label_loginid = new JLabel("아이디");
		input_id = new JTextField("", 10);
		label_loginpw = new JLabel("비밀번호");
		input_pw = new JTextField("", 10);

		label_loginid.setBounds(40, 80, 95, 22);
		label_loginpw.setBounds(40, 110, 95, 22);
		input_id.setBounds(110, 80, 100, 22);
		input_pw.setBounds(110, 110, 100, 22);

		add(label_loginid);
		add(input_id);
		add(label_loginpw);
		add(input_pw);

	}

	private void setButtons() {

		JButton btn_logindo = new JButton("로그인");
		JButton btn_joindo = new JButton("가입하기");

		btn_logindo.setBounds(120, 150, 95, 22);
		btn_joindo.setBounds(40, 150, 95, 22);
		
		ctl = new Controller();
		btn_logindo.addActionListener(e -> {
			ctl.login(input_id.getText(),input_pw.getText()); // 로그인 요청
		});
		btn_joindo.addActionListener(e -> {

		});

		add(btn_logindo);
		add(btn_joindo);

	}

}
