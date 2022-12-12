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
	Socket socket = null;
	ArrayList<GameHandlerObject> list = new ArrayList<GameHandlerObject>();
	private BufferedWriter writer;
	private BufferedReader reader;
	ObjectOutputStream senduser;
	UserDAO userdao;

	/*
	 * public static void main(String[] args) { MultiServer multiServer = new
	 * MultiServer(); multiServer.start(); }
	 */

	public void start() {
		ServerSocket serverSocket = null;
		
		while (true) {
			try {
				serverSocket = new ServerSocket();
				serverSocket.bind(new InetSocketAddress(8000));
				while (true) {
					System.out.println("[클라이언트 연결대기중]");
					socket = serverSocket.accept();
					// mainpanel 에서 버튼을 누르면 소켓연결 
					System.out.println("[클라이언트" + socket.getInetAddress() + " 접속]");
					try { 
						writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())); // 문자열
						reader =  new BufferedReader(new InputStreamReader(socket.getInputStream())); // 문자열
						
						login(reader.readLine().split(","));
						

						
					} catch (IOException e) {
						e.printStackTrace();
					}catch(NullPointerException e) {
						e.printStackTrace();
					}
					while (reader != null) {
						try {
							System.out.println("보낸 메시지 : "+reader.readLine());
							System.out.println("보낸 메시지 : "+reader.readLine());
							writer.write("hello world!");
							writer.flush();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					// client가 접속할때마다 새로운 스레드 생성
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
	
	
	
	
	private void login(String[] idpw) {
		OutputStream os;
		try {
			os = socket.getOutputStream();
	        senduser = new ObjectOutputStream(os); // 객체 보내기용 
	        senduser.writeObject(userdao.loginCheck(idpw[0], idpw[1]));
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	
	
	
	
}// multi server 

class GameHandlerObject extends Thread {

	List<GameHandlerObject> list;
	Socket socket = null;
	BufferedReader reader = null;
	BufferedWriter writer = null;

	public GameHandlerObject(Socket socket, List<GameHandlerObject> list) {
		this.socket = socket;
		this.list = list;
		
	}

	@Override
	public void run() {
		try {
			// 최초1회는 client이름을 수신
			System.out.println("[클라이언트 로그인]");
//			sendAll("[" + name + "]님이 들어오셨습니다.");
//			
			
		} finally {
//			sendAll("[" + name + "]님이 나가셨습니다");
//			list.remove(out);
			if ( writer != null) try{writer.close();} catch(IOException e){}
			if ( reader != null) try{reader.close();} catch(IOException e){}

            if ( socket != null) try{socket.close();} catch(IOException e){}
		}
		System.out.println("[ 클라이언트 연결종료]");
	}

//	private void sendAll (String s) {
//		for (PrintWriter out: list) {
//			out.println(s);
//			out.flush();
//		}
//	}
}