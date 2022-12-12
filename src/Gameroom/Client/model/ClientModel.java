<<<<<<< HEAD
package Gameroom.Client.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.UnknownHostException;

import Gameroom.Utility.DataDTO;
import Gameroom.Utility.Info;
import Gameroom.Utility.UserDTO;

//import Gameroom.Client.MultiClient.SendThread;

public class ClientModel implements Runnable {
	Socket socket = null;
	ObjectInputStream reader = null;
	ObjectOutputStream writer = null;

	String[] userInfoList = new String[5];

	public ClientModel() {

	}

	public void login(String id, String pw) {
		try {
			if (socket == null) {
				socket = new Socket("localhost", 8000);
				System.out.println("[서버와 연결되었습니다]");
				writer = new ObjectOutputStream(socket.getOutputStream());
				reader = new ObjectInputStream(socket.getInputStream());
			}
		} catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다.");
			e.printStackTrace();
			System.exit(0);
		} catch (IOException e) {
			System.out.println("[서버 접속끊김]");
		}
		try {
			DataDTO<String[]> sendDTO = new DataDTO<String[]>();
			
			sendDTO.setData(new String[] {id,pw});
			sendDTO.setCommand(Info.LOGIN);
			
			writer.writeObject(sendDTO);
			writer.flush();
			
			
			System.out.println("서버에 보낸 메시지 : " + id + "/"+pw);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		Thread t = new Thread(this);
		t.start();
	}
	
	public void findgame() {
		
		
		
	}

	
	
	// 스레드 오버라이드
	@Override
	public void run() {
		DataDTO dto = null;
		// 서버로부터 데이터 받기
		try{
			while(true){
				dto=(DataDTO)reader.readObject();

				//System.out.println("배열 크기:"+ar.length);
				//사용자가 접속을 끊었을 경우. 프로그램을 끝내서는 안되고 남은 사용자들에게 퇴장메세지를 보내줘야 한다. 
				if(dto.getCommand()==Info.LOGOUT){
					DataDTO sendDto = new DataDTO();
					//나가려고 exit를 보낸 클라이언트에게 답변 보내기
					sendDto.setCommand(Info.LOGOUT);
					writer.writeObject(sendDto);
					writer.flush();
					reader.close();
					writer.close();
					socket.close();
					break;
				} else if(dto.getCommand()==Info.LOGIN){
					UserDTO userInfo = (UserDTO) dto.getData();
					System.out.println(userInfo.getId()+"님 로그인이 되었습니다.");
				} else if(dto.getCommand()==Info.SEND){
					
				}
			}//while

		} catch(IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}	
	}

	public String[] getUserInfoList() {
		return userInfoList;
	}

	public Socket getsocket() {
		return socket;
	}
=======
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
>>>>>>> branch 'main' of https://github.com/skyacademia/WordGameProject.git
}