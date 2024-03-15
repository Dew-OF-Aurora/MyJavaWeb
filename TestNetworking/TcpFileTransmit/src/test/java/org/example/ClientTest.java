package org.example;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientTest {
	public static void main(String[] args) {

		DataInputStream dataInputStream;
		DataOutputStream dataOutputStream;
		try (ServerSocket serverSocket = new ServerSocket()) {
			serverSocket.bind(new InetSocketAddress("localhost", 8000));
			Socket accept = serverSocket.accept();
			dataInputStream = new DataInputStream(new BufferedInputStream(accept.getInputStream()));

			String fileName = dataInputStream.readUTF();
			System.out.println(fileName);
			long length = dataInputStream.readLong();
			System.out.println(length);

			dataOutputStream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("C:\\Users\\AuroraCXLv\\Desktop\\" + fileName + ".txt")));
			byte[] bytes = new byte[1024];
			int temp;
			int count = 0;
			while ((temp = dataInputStream.read(bytes)) != -1) {
				count += temp;
				dataOutputStream.write(bytes, 0, temp);
			}
			System.out.println(count);
			dataOutputStream.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}