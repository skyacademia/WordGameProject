package Gameroom.Client.model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.UnknownHostException;

import Gameroom.Utility.DataDTO;
import Gameroom.Utility.Info;
import Gameroom.Utility.UserDTO;


public class ClientModel implements Runnable {
	Socket socket = null;
	ObjectInputStream reader = null;
	ObjectOutputStream writer = null;
	UserDTO user = new UserDTO();
	String[] userInfoList = new String[5];
	DataDTO<UserDTO> dto = null;

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
	

	
	
	// 스레드 오버라이드
	@Override
	public void run() {
		
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
					user = (UserDTO) dto.getData();
					System.out.println(user.getId()+"님 로그인이 되었습니다.");
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

	
	public void sendMsg(String msg) {
		
		dto.setMessage(msg);
		dto.setData(user);
		dto.setCommand(Info.SEND);
		try {
			writer.writeObject(dto);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void findgame() {
		
		
		
	}

	
	
	public Socket getsocket() {
		return socket;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
	
	
}