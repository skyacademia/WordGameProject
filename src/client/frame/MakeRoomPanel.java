package client.frame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MakeRoomPanel extends JPanel {
	
	JButton create_btn;
	JButton back_btn;
	
	JTextField input_roomname;
	JLabel label_rname;
	
	
	public MakeRoomPanel() {
		setLayout(null);
		setCreateform();
	}
	
	
	private void setCreateform() {
		input_roomname = new JTextField("", 20);
		label_rname = new JLabel("�� ����");
		create_btn = new JButton("�����");
		back_btn = new JButton("�ڷ�");
		
		input_roomname.setBounds(110,50,90,22);
		label_rname.setBounds(50,50,50,22);
		
		back_btn.setBounds(40, 200, 90, 22);
		create_btn.setBounds(150, 200, 90, 22);
		
		add(input_roomname);
		add(label_rname);
		add(create_btn);
		add(back_btn);
		
		
		create_btn.addActionListener(e -> {
			// GameRoom ��Ű���� �ִ� class ���̶� �����ؾ� �ϰ� ���� ȭ�鵵 ������ �ؿ� ���� �ȸ���.. 
			
		});
	
	
	}
	
}
