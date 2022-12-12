package Gameroom.Server;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import Gameroom.Utility.DataDTO;
import Gameroom.Utility.Info;
import Gameroom.Utility.UserDAO;
import Gameroom.Utility.UserDTO;

public class MultiServer {
	ServerSocket serverSocket;
	ArrayList<GameHandlerObject> list = new ArrayList<GameHandlerObject>();

	public void start() {
		ServerSocket serverSocket = null;
		Socket socket = null;
		while (true) {
			try {
				serverSocket = new ServerSocket();
				serverSocket.bind(new InetSocketAddress(8000));
				while (true) {
					System.out.println("[클라이언트 연결대기중]");
					socket = serverSocket.accept();
					System.out.println("[클라이언트" + socket.getInetAddress() + " 접속]");
					// client가 접속할때마다 새로운 스레드 생성
					GameHandlerObject handler = new  GameHandlerObject(socket,list);
					handler.start();  //스레드 시작- 스레드 실행
					list.add(handler); 
				}
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (serverSocket != null) {
					try {
						serverSocket.close();
						System.out.println("[서버종료]");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("[서버소켓통신에러]");
					}
				}
			}
		}
	}
}

class GameHandlerObject extends Thread {

	List<GameHandlerObject> list;
	Socket socket = null;
	ObjectInputStream reader;
	ObjectOutputStream writer;

	public GameHandlerObject(Socket socket, List<GameHandlerObject> list) {
		this.socket = socket;
		this.list = list;
		try {
			writer = new ObjectOutputStream(socket.getOutputStream());
			reader = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		DataDTO dto = null;
		String id;
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
					//남아있는 클라이언트에게 퇴장메세지 보내기
					list.remove(this);

					break;
				} else if(dto.getCommand()==Info.LOGIN){
					String[] userInfo = (String[]) dto.getData();
					UserDAO dao = new UserDAO();
					
					// login do
					UserDTO userdto =dao.login(userInfo[0],userInfo[1]);
					System.out.println(userdto.getId()+" 로그인 승인");
					DataDTO<UserDTO> sendDto = new DataDTO<UserDTO>();
					sendDto.setCommand(Info.LOGIN);
					sendDto.setData(userdto);
					writer.writeObject(sendDto);
					writer.flush();
				} else if(dto.getCommand()==Info.SEND){
					
				} else if(dto.getCommand() == Info.MAKEROOM) { 
					// 상대 찾기 
					
					
				}
			}//while

		} catch(IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}	
	}
	
	//다른 클라이언트에게 전체 메세지 보내주기
	public void broadcast(DataDTO sendDto) throws IOException {
		for(GameHandlerObject handler: list){
			handler.writer.writeObject(sendDto); //핸들러 안의 writer에 값을 보내기
			handler.writer.flush();  //핸들러 안의 writer 값 비워주기
		}
	}

//	private void sendAll (String s) {
//		for (PrintWriter out: list) {
//			out.println(s);
//			out.flush();
//		}
//	}
}