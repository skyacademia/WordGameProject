package client.frame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainPanel extends JPanel {
	public static MainFrame frame;

	public MainPanel(MainFrame frame) {

		MainPanel.frame = frame;
		setLayout(null);
		setBounds(0, 70, 300, 300);
		showLogo();
		setEnterButton();

	}

	private void setEnterButton() { // �����ϱ� ��ư
		
		JButton btn_enter = new JButton("�����ϱ�");
		btn_enter.setBounds(70, 40, 150, 100);

		btn_enter.addActionListener(e -> { // �α���+ȸ������â ������ ��

			LoginPanel loginpan = new LoginPanel();
			MainPanel.frame.change(loginpan);

		});

		add(btn_enter);

	}

	private void showLogo() {

		JLabel hellolabel = new JLabel("�����ձ� �����Դϴ�..(�ΰ����� �־ �ɰŰ����...");
		hellolabel.setBounds(10, 30, 300, 22);
		add(hellolabel);
	}
}
