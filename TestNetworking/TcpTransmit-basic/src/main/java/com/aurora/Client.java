package com.aurora;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class Client {
    public static void main(String[] args) throws IOException {

        BufferedReader in = null;
        BufferedWriter out = null;
        try (Socket client = new Socket();
        ) {
            SocketAddress address = new InetSocketAddress("localhost", 9996);
            client.connect(address);
            in = new BufferedReader(new InputStreamReader(client.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            out.write("你好这里是客户端");
            out.newLine();
            out.flush();
            System.out.println(in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null && out != null) {
                in.close();
                out.close();
            }
        }
    }
}
