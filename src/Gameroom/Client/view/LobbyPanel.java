package Gameroom.Client.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

public class LobbyPanel extends JPanel{
	private JList userList;
	

	public LobbyPanel() {
		this.
		setLayout(null);
		enterMenu();

	}

	private void enterMenu() {

		JButton btn_game = new JButton("게임하기"); 
		JLabel title = new JLabel("끝말잇기 게임에 오신것을 환영!");

//		btn_game.addActionListener(e -> { 
//			MakeGamePanel makeGamepan =  new MakeGamePanel();
//			MainPanel.frame.change(makeGamepan);
//		});


		title.setBounds(30, 20, 300, 22);
		btn_game.setBounds(70, 32, 150, 60);
		add(btn_game);

		add(title);

	}
	
	public void userList() {
		

	}
	
	
	
	
	
	
	/* 필요없어짐 ㅎ
	 * public void makeUserList() { JScrollPane scrollPane = new JScrollPane();
	 * scrollPane.setBounds(34, 211, 200, 548); add(scrollPane);
	 * 
	 * userList = new JList(); userList.setCellRenderer(new
	 * DefaultListCellRenderer() {
	 * 
	 * @Override public int getHorizontalAlignment() { // TODO Auto-generated method
	 * stub return CENTER; } }); // scrollPane.setViewportView(userList);
	 * scrollPane.setViewportView(scrollPane);
	 * 
	 * }
	 */
	
}
