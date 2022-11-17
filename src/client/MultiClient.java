package client;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

public class MultiClient {

	
	
	Socket socket = null;
	BufferedReader in = null;

	public void start(String name) {

		try {
			socket = new Socket("localhost", 8000);
			System.out.println("[서버와 연결되었습니다]");

			Thread sendThread = new SendThread(socket, name);
			sendThread.start();

			/*
			 * in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			 * while (in != null) { String inputMsg = in.readLine(); if (("[" + name +
			 * "]님이 나가셨습니다").equals(inputMsg)) break; System.out.println("From:" +
			 * inputMsg); }
			 */

		} catch (IOException e) {
			System.out.println("[서버 접속끊김]");
		}

	}

	public void stop() {

		try {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
		}
		System.out.println("[서버 연결종료]");
	}
}
