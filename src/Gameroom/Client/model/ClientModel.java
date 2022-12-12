package Gameroom.Client.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.HashMap;

import Gameroom.Utility.DataDTO;
import Gameroom.Utility.UserDAO;
import Gameroom.Utility.UserDTO;

//import Gameroom.Client.MultiClient.SendThread;

public class ClientModel implements Runnable {
	Socket socket = null;
	BufferedReader reader = null;
	BufferedWriter writer = null;
	ObjectInputStream receiver = null;
	DataDTO dto = null;
	String[] userInfoList = new String[5];

	public ClientModel() {

	}

	public UserDTO login(String id, String pw) {
		UserDTO loginuser;
		
		try {
			writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 문자열 쓰기
			reader = new BufferedReader(new InputStreamReader(socket.getInputStream())); // 문자열 읽기
            InputStream is = socket.getInputStream();
            receiver = new ObjectInputStream(is); // 오브젝트 

           
			writer.write(id + "," + pw);
			writer.flush();
			
			loginuser = (UserDTO) receiver.readObject();
			if(loginuser == null) {
				System.out.println("0");
			} 			
			System.out.println("서버에 보낸 메시지 : " + user.getId() + "/" + user.getPw());
			System.out.println("서버에서 보낸 메시지 : " + reader.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
			return loginuser;
		
	}

	
	public Socket serverConnect() {
		try {
			return new Socket("localhost", 8000);
			
		} catch (java.net.UnknownHostException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return null;
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