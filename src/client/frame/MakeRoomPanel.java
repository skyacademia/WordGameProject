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
		label_rname = new JLabel("방 제목");
		create_btn = new JButton("만들기");
		back_btn = new JButton("뒤로");
		
		input_roomname.setBounds(110,50,90,22);
		label_rname.setBounds(50,50,50,22);
		
		back_btn.setBounds(40, 200, 90, 22);
		create_btn.setBounds(150, 200, 90, 22);
		
		add(input_roomname);
		add(label_rname);
		add(create_btn);
		add(back_btn);
		
		
		create_btn.addActionListener(e -> {
			// GameRoom 패키지에 있는 class 들이랑 연결해야 하고 게임 화면도 만들어야 해용 아직 안만듬.. 
			
		});
	
	
	}
	
}
