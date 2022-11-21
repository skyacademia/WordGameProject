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

		add(btn_logindo);
		add(btn_joindo);

		btn_logindo.addActionListener(e -> {
			String id = input_id.getText().trim();
			String pw = input_pw.getText().trim();

			if (id.length() == 0 || pw.length() == 0) {
				JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!",
						JOptionPane.DEFAULT_OPTION);
				return;
			}

			if (id.equals("test") && pw.equals("1234")) { // 이 부분은 서버 db 연결해서 확인하는 방식으로 바꾸어야 할것 같아요~ 일단 임시임당
				JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
				/*
				 * // 이부분은 로그인하는 곳으로 옮기면 될것같아요 로그인이 완료 되면 소켓을 생성 + 패넣변경 client = new
				 * MultiClient(); String name = "임시 이름" + (int) (Math.random() * 10);
				 * client.start(name); // 로그인이 되면 소켓을 연결한다..
				 */
				EnterPanel enterpanel = new EnterPanel();
				MainPanel.frame.change(enterpanel);

			} else {
				JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
			}

		});


	}
	
	public void LoginAction(ActionListener listener) {
		btn_logindo.addActionListener(listener);
	}
	public void JoinAction(ActionListener listener) {
		btn_joindo.addActionListener(listener);
	}
	
	
	String id;
	String pw;
//	String id = input_id.getText().trim();
//	String pw = input_pw.getText().trim();

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
