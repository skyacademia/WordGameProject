package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import client.MultiClient;
import client.frame.JoinPanel;
import client.frame.LoginPanel;
import client.frame.MainPanel;

public class UserController {

	JPanel userview; // login or join pan
	MultiClient client;
 
	public UserController(JPanel view) {
		userview = view;
	}


	public void Action01Listener() {
		((MainPanel)this.userview).Action01(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				client = new MultiClient();
				String name = "임시 이름" + (int) (Math.random() * 10); // 구분자 
				client.start(name); // 소켓 연결
				
				LoginPanel loginpan = new LoginPanel();
				MainPanel.frame.change(loginpan);
			}

		});
	} 
	
	public void loginActionListener() { // 로그인 버튼 눌렀을때
		String id = ((LoginPanel) userview).getInput_id().getText().trim();
		String pw = ((LoginPanel) userview).getInput_pw().getText().trim();
		
		((LoginPanel) this.userview).LoginAction(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (id.length() == 0 || pw.length() == 0) {
					JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력!",
							JOptionPane.DEFAULT_OPTION);
					return; // 다시 돌아가게 해야함.. 되는지 모르곘다 ^^; 
				}

				/*
				 * if (db결과값이 있다?) { JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!",
				 * JOptionPane.DEFAULT_OPTION);
				 * 
				 * EnterPanel enterpanel = new EnterPanel(); MainPanel.frame.change(enterpanel);
				 * }else { JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인!",
				 * JOptionPane.DEFAULT_OPTION); }
				 */

			}
		});
	}

	public void joinActionListener() { // 회원가입 버튼 눌렀을때
		((JoinPanel) this.userview).JoinAction(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// 가입하는 창 

			}
		});
	}
}
