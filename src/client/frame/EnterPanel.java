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

		JButton btn_game = new JButton("�ٷ� �����ϱ�");
		JButton btn_makeroom = new JButton("�� �����");
		JLabel title = new JLabel("�����ձ� ���ӿ� ���Ű��� ȯ��!");

		btn_game.addActionListener(e -> { // ���� ���� ������ ����?
			// �𸣰ھ�� ��ư 1���� ���� �׷��� �׳� �־� �þ�� �̺κп� ���� ��� ������� �����Ű��ƿ�
		});
		btn_makeroom.addActionListener(e -> { // �� ����� â ����
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
