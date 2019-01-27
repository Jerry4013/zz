import com.zzpublic.socket.Connector;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        System.out.println("client 1");
        Socket socket = new Socket("localhost", 8888);

        System.out.println("client 2");
        Connector connector = new Connector(socket);

        System.out.println("client 3");
        connector.writeLine("hello socket");
        System.out.println("client 4");

    }
}
