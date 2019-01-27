package zz.client.net;

import com.zzpublic.socket.Connector;
import zz.client.service.UserService;
import zz.common.net.Request;
import zz.common.net.Response;

import java.io.IOException;
import java.net.Socket;

public class RequestSender {
    public Response send(Request request){
        String serverIp = System.getenv("SERVER_IP");
        String serverPortString = System.getenv("SERVER_PORT");
        int serverPort = Integer.valueOf(serverPortString);

        Socket socket = null;
        try {
            socket = new Socket(serverIp, serverPort);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        Connector connector = new Connector(socket);
        connector.writeLine(UserService.authentication);
        connector.writeLine(request.getAction());
        connector.writeLine(request.getData());

        String status = connector.readLine();
        String data = connector.readLine();

        Response response = new Response();
        response.setStatus(status);
        response.setData(data);

        connector.close();

        return response;
    }
}
