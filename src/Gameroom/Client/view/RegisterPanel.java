<<<<<<< HEAD
package Gameroom.Client.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gameroom.Client.controller.Controller;

public class RegisterPanel extends JPanel {

	
	Controller ctl;
	// 회원가입 라벨 필드 
	JLabel label_registerid;
	JTextField input_id;
	JLabel label_registerpw;
	JTextField input_pw;
	JLabel label_registerpwcheck;
	JTextField input_pwcheck;
	// 가입버튼
	JButton btn_joindo;
	
	

	public RegisterPanel() {
		setLayout(null);
		loginform();
		setButtons();
	}

	private void loginform() {

		label_registerid = new JLabel("아이디");
		input_id = new JTextField("", 10);
		label_registerpw = new JLabel("비밀번호");
		input_pw = new JTextField("", 10);
		label_registerpwcheck = new JLabel("비밀번호 확인");
		input_pwcheck = new JTextField("", 10);

		label_registerid.setBounds(40, 80, 95, 22);
		label_registerpw.setBounds(40, 110, 95, 22);
		label_registerpwcheck.setBounds(40, 140, 95, 22);
		input_id.setBounds(130, 80, 100, 22);
		input_pw.setBounds(130, 110, 100, 22);
		input_pwcheck.setBounds(130, 140, 100, 22);
		add(label_registerid);
		add(input_id);
		add(label_registerpw);
		add(input_pw);
		add(label_registerpwcheck);
		add(input_pwcheck);
	}

	private void setButtons() {


		JButton btn_registerdo = new JButton("가입하기");
		btn_registerdo.setBounds(40, 180, 95, 22);
		
//		ctl = new Controller();
//		btn_logindo.addActionListener(e -> {
//			ctl.login(input_id.getText(),input_pw.getText()); // 로그인 요청
//		});
//		btn_joindo.addActionListener(e -> {
//
//		});

		add(btn_registerdo);

	}

}
=======
package Gameroom.Client.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Gameroom.Client.controller.Controller;

public class RegisterPanel extends JPanel {

	
	Controller ctl;
	// 회원가입 라벨 필드 
	JLabel label_registerid;
	JTextField input_id;
	JLabel label_registerpw;
	JTextField input_pw;
	JLabel label_registerpwcheck;
	JTextField input_pwcheck;
	// 가입버튼
	JButton btn_joindo;
	
	

	public RegisterPanel() {
		setLayout(null);
		loginform();
		setButtons();
	}

	private void loginform() {

		label_registerid = new JLabel("아이디");
		input_id = new JTextField("", 10);
		label_registerpw = new JLabel("비밀번호");
		input_pw = new JTextField("", 10);
		label_registerpwcheck = new JLabel("비밀번호 확인");
		input_pwcheck = new JTextField("", 10);

		label_registerid.setBounds(40, 80, 95, 22);
		label_registerpw.setBounds(40, 110, 95, 22);
		label_registerpwcheck.setBounds(40, 140, 95, 22);
		input_id.setBounds(130, 80, 100, 22);
		input_pw.setBounds(130, 110, 100, 22);
		input_pwcheck.setBounds(130, 140, 100, 22);
		add(label_registerid);
		add(input_id);
		add(label_registerpw);
		add(input_pw);
		add(label_registerpwcheck);
		add(input_pwcheck);
	}

	private void setButtons() {


		JButton btn_registerdo = new JButton("가입하기");
		btn_registerdo.setBounds(40, 180, 95, 22);
		
//		ctl = new Controller();
//		btn_logindo.addActionListener(e -> {
//			ctl.login(input_id.getText(),input_pw.getText()); // 로그인 요청
//		});
//		btn_joindo.addActionListener(e -> {
//
//		});

		add(btn_registerdo);

	}

}
>>>>>>> branch 'main' of https://github.com/skyacademia/WordGameProject.git
