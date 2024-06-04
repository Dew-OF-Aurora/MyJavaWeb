import org.junit.Test;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author:Aurora
 * @create: 2023-06-29 08:56
 * @Description:
 */
public class ServerTest {
    @Test
    public void Server01() throws IOException {
        BufferedReader in = null;
        BufferedWriter out = null;
        while (true){
            try (ServerSocket server = new ServerSocket()) {
                server.bind(new InetSocketAddress("localhost", 9996));
                Socket accept = server.accept();
                //拿到客户端的接收socket端口
                System.out.println("建立连接->"+accept.getInetAddress()+":"+accept.getPort());
                //构建套接字输入流，接收客户端数据
                in = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                //构建套接字输出流，以发送数据给客户端
                out = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));

                String readLine = in.readLine();
                out.write("服务器收到：" + readLine);
                out.newLine();
                out.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                if (in != null && out != null) {
                    in.close();
                    out.close();
                }
            }
        }
    }
}
