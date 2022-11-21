package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import client.frame.LoginPanel;

public class UserController {

	LoginPanel loginview;

	public UserController(LoginPanel view) {
		loginview = view;
	}

	public void loginActionListener() { // 로그인 버튼 눌렀을때
		String id = loginview.getInput_id().getText().trim();
		String pw = loginview.getInput_pw().getText().trim();
		this.loginview.LoginAction(new ActionListener() {

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
		this.loginview.LoginAction(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// joinpanel 만들어서 붙여주는 작업 

			}
		});
	}
}
