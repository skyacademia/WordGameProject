package client.frame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import client.MultiClient;

public class LoginPanel extends JPanel {

	public MultiClient client;

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

		label_loginid = new JLabel("���̵�");
		input_id = new JTextField("", 10);
		label_loginpw = new JLabel("��й�ȣ");
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

		JButton btn_logindo = new JButton("�α���");
		JButton btn_joindo = new JButton("�����ϱ�");

		btn_logindo.setBounds(120, 150, 95, 22);
		btn_joindo.setBounds(40, 150, 95, 22);

		add(btn_logindo);
		add(btn_joindo);

		btn_logindo.addActionListener(e -> {
			String id = input_id.getText().trim();
			String pw = input_pw.getText().trim();

			if (id.length() == 0 || pw.length() == 0) {
				JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �Է� �ϼž� �˴ϴ�.", "���̵� ����� �Է�!",
						JOptionPane.DEFAULT_OPTION);
				return;
			}

			if (id.equals("test") && pw.equals("1234")) { // �� �κ��� ���� db �����ؼ� Ȯ���ϴ� ������� �ٲپ�� �Ұ� ���ƿ�~ �ϴ� �ӽ��Ӵ�
				JOptionPane.showMessageDialog(null, "�α��� ����", "�α��� Ȯ��!", JOptionPane.DEFAULT_OPTION);

				// �̺κ��� �α����ϴ� ������ �ű�� �ɰͰ��ƿ� �α����� �Ϸ� �Ǹ� ������ ���� + �гֺ���
				client = new MultiClient();
				String name = "�ӽ� �̸�" + (int) (Math.random() * 10);
				client.start(name); // �α����� �Ǹ� ������ �����Ѵ�..

				EnterPanel enterpanel = new EnterPanel();
				MainPanel.frame.change(enterpanel);

			} else {
				JOptionPane.showMessageDialog(null, "�α��� ����", "�α��� Ȯ��!", JOptionPane.DEFAULT_OPTION);
			}

		});

		btn_joindo.addActionListener(e ->

		{
			// ����â ���� ����
			System.out.println("����â ��������");

		});

	}

}
