package org.example;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.URL;

public class Main {
	public static void main(String[] args) {
		String fileName = "tempText";
		DataInputStream dataInputStream;
		DataOutputStream outputStream;
		URL url = ClassLoader.getSystemResource(fileName);
		long length = new File(url.getPath()).length();
		try (Socket client = new Socket();) {
			SocketAddress address = new InetSocketAddress("localhost", 8000);
			client.connect(address);

			dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(url.getPath())));
			outputStream = new DataOutputStream(new BufferedOutputStream(client.getOutputStream()));

			outputStream.writeUTF(fileName);
			outputStream.writeLong(length);

			byte[] fileByte = new byte[1024];
			int count = 0;
			int temp;
			while ((temp = dataInputStream.read(fileByte)) != -1) {
				count++;
				outputStream.write(fileByte, 0, temp);
			}
			System.out.println(count * 1024);
			System.out.println(length);
			outputStream.flush();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}