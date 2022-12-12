package Gameroom.Client.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.HashMap;

import Gameroom.Utility.DataDTO;
import Gameroom.Utility.UserDAO;
import Gameroom.Utility.UserDTO;

//import Gameroom.Client.MultiClient.SendThread;

public class ClientModel implements Runnable {
	Socket socket = null;
	BufferedReader reader = null;
	BufferedWriter writer = null;
	DataDTO dto = null;
	String[] userInfoList = new String[5];
	UserDAO userdao = new UserDAO();

	public ClientModel() {

	}

	public UserDTO login(String id, String pw) {

		UserDTO loginuser = userdao.loginCheck(id, pw);

		if (loginuser == null) {
			System.out.println("false");
			return null;

		} else {
			System.out.println("true");
			try {
				if (socket == null) {
					socket = new Socket("localhost", 8000);
					
					loginuser.setUserSocket(socket);
					
					System.out.println("[서버와 연결되었습니다]");
					}
			} catch (UnknownHostException e) {
				System.out.println("서버를 찾을 수 없습니다.");
				e.printStackTrace();
				System.exit(0);
			} catch (IOException e) {
				System.out.println("[서버 접속끊김]");
			}
			return loginuser;
			
		}
	}

	
	private void chat(UserDTO user) {

		Socket socket  = user.getUserSocket();
		
		try {
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			writer.write(user.getId());
			writer.write(user.getPw());
			
			writer.flush();
			System.out.println("서버에 보낸 메시지 : " + user.getId() + "/" + user.getPw());
			System.out.println("서버에서 보낸 메시지 : " + reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	
	// 스레드 오버라이드
	@Override
	public void run() {
		// 서버로부터 데이터 받기
		DataDTO<HashMap<String, String>> dto = null;

	}

	public String[] getUserInfoList() {
		return userInfoList;
	}

	public Socket getsocket() {
		return socket;
	}
}