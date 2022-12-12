package Gameroom.Client.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import Gameroom.Utility.DataDTO;
import Gameroom.Utility.Info;

//import Gameroom.Client.MultiClient.SendThread;

public class ClientModel implements Runnable {
	Socket socket = null;
	BufferedReader reader = null;
	BufferedWriter writer = null;
	DataDTO dto = null;
	String[] userInfoList = new String[5];

	public ClientModel() {

	}

	public void login(String id, String pw) {
		try {
			if (socket == null) {
				socket = new Socket("localhost", 8000);
				System.out.println("[서버와 연결되었습니다]");
				writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			}
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다.");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("[서버 접속끊김]");
		}
		try {
			writer.write(id);
			writer.write(pw);
			writer.flush();
			System.out.println("서버에 보낸 메시지 : " + id + "/"+pw);
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