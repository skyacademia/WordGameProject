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
			System.out.println("[������ ����Ǿ����ϴ�]");

			Thread sendThread = new SendThread(socket, name);
			sendThread.start();

			/*
			 * in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			 * while (in != null) { String inputMsg = in.readLine(); if (("[" + name +
			 * "]���� �����̽��ϴ�").equals(inputMsg)) break; System.out.println("From:" +
			 * inputMsg); }
			 */

		} catch (IOException e) {
			System.out.println("[���� ���Ӳ���]");
		}

	}

	public void stop() {

		try {
			if (socket != null && !socket.isClosed()) {
				socket.close();
			}
		} catch (IOException e) {
		}
		System.out.println("[���� ��������]");
	}
}
