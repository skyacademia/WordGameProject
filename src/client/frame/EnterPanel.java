package client.frame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class EnterPanel extends JPanel {

	public EnterPanel() {
		setLayout(null);
		enterMenu();

	}

	private void enterMenu() {

		JButton btn_game = new JButton("바로 게임하기");
		JButton btn_makeroom = new JButton("방 만들기");
		JLabel title = new JLabel("끝말잇기 게임에 오신것을 환영!");

		btn_game.addActionListener(e -> { // 게임 방이 있으면 들어가게?
			// 모르겠어요 버튼 1개만 놓기 그래서 그냥 넣어 봤어요 이부분에 대해 얘기 나누어보면 좋을거같아여
		});
		btn_makeroom.addActionListener(e -> { // 방 만들기 창 구현
			MakeRoomPanel makeroompan =  new MakeRoomPanel();
			MainPanel.frame.change(makeroompan);
		});

		title.setBounds(30, 20, 300, 22);
		btn_game.setBounds(70, 32, 150, 60);
		btn_makeroom.setBounds(70, 100, 150, 60);
		add(btn_game);
		add(btn_makeroom);
		add(title);

	}

}
