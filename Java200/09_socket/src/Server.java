import com.zzpublic.socket.Connector;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        System.out.println("server 1");
        ServerSocket serverSocket = new ServerSocket(8888);

        System.out.println("server 2");
        Socket socket = serverSocket.accept();

        System.out.println("Server 3");
        Connector connector = new Connector(socket);
        System.out.println("Server 4");
        String message = connector.readLine();

        System.out.println("Server 5");
        System.out.println(message);
        System.out.println("Server 6");
        serverSocket.close();
    }
}
