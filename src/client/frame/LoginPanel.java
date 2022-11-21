package client.frame;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel {



	JLabel label_loginid;
	JTextField input_id;
	JLabel label_loginpw;
	JTextField input_pw;

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
		
		
		btn_joindo.addActionListener(e -> {
		// 화면이동 가입창으로~~ 	
			
			
		});

		add(btn_logindo);
		add(btn_joindo);


	}
	
	public void LoginAction(ActionListener listener) {
		btn_logindo.addActionListener(listener);
	}



	public JTextField getInput_id() {
		return input_id;
	}

	public void setInput_id(JTextField input_id) {
		this.input_id = input_id;
	}

	public JTextField getInput_pw() {
		return input_pw;
	}

	public void setInput_pw(JTextField input_pw) {
		this.input_pw = input_pw;
	}


	
	

}
