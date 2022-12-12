package Gameroom.Client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class UsetConnThread extends Thread {
	
	Socket socket = null;
	String name;

	Scanner scanner = new Scanner(System.in);

	public UsetConnThread(Socket socket, String name) {
		this.socket = socket;
		this.name = name;
	}

	@Override
	public void run() {
		try {
			
			// 가져온 코드 연결  
			// 최초1회는 client의 name을 서버에 전송
			PrintStream out = new PrintStream(socket.getOutputStream());
			out.println(name);
			out.flush();

			while (true) {
				String outputMsg = scanner.nextLine();
				out.println(outputMsg);
				out.flush();
				if ("quit".equals(outputMsg))
					break;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
