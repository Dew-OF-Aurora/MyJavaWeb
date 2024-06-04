package com.aurora;

import javax.crypto.Cipher;
import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    /**
     * 客户端程序
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {
        String filename = "test.txt";
        SocketAddress address = new InetSocketAddress("localhost", 9996);
        Socket client = new Socket();
        client.connect(address);
        DataInputStream DIS = new DataInputStream(new BufferedInputStream(
                Objects.requireNonNull(ClassLoader.getSystemClassLoader().getResourceAsStream(filename))));
        DataOutputStream DOS = new DataOutputStream(new DataOutputStream(client.getOutputStream()));
        BufferedReader reader = new BufferedReader(new InputStreamReader(client.getInputStream()));


        //临时Byte数组
        byte[] buf = new byte[1024];
        int len;
        // 将数据从输入流循环读入缓冲区, 当读到文件最后，会得到值-1
        while((len=DIS.read(buf))!=-1){
            DOS.write(buf,0,len);
        }
        DOS.flush();

    }
}
