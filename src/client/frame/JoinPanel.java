package client.frame;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JoinPanel extends JPanel {



	JLabel label_joinid;
	JTextField input_id;
	JLabel label_joinpw;
	JTextField input_pw;
	JLabel label_joinname;
	JTextField input_name;

	
	JButton btn_join;
	JButton btn_back;

	public JoinPanel() {
		setLayout(null);
		joinform();
		setButtons();
	}

	private void joinform() {

		label_joinid = new JLabel("아이디");
		input_id = new JTextField("", 10);
		label_joinpw = new JLabel("비밀번호");
		input_pw = new JTextField("", 10);
		label_joinname = new JLabel("이름");
		input_name = new JTextField("", 10);

		label_joinid.setBounds(40, 80, 95, 22);
		label_joinpw.setBounds(40, 110, 95, 22);
		label_joinname.setBounds(40, 140, 95, 22);
		input_id.setBounds(110, 80, 100, 22);
		input_pw.setBounds(110, 110, 100, 22);
		input_name.setBounds(110, 140, 100, 22);

		add(label_joinid);
		add(input_id);
		add(label_joinpw);
		add(input_pw);
		add(label_joinname);
		add(input_name);

	}

	private void setButtons() {

		JButton btn_join = new JButton("가입하기");
		JButton btn_back = new JButton("취소");

		btn_join.setBounds(120, 150, 95, 22);
		btn_back.setBounds(40, 150, 95, 22);

		add(btn_join);
		add(btn_back);

		btn_back.addActionListener(e ->{
			// 뒤로돌아가게~ 
			
		});

	}
	
	public void JoinAction(ActionListener listener) {
		btn_join.addActionListener(listener);
	}


	
	
	
	
	

}
