package zz.server.net;

import com.zzpublic.socket.Connector;
import zz.server.service.UserService;
import zz.common.net.Request;
import zz.common.net.Response;
import zz.server.controller.TodoItemController;
import zz.server.controller.TodoListController;
import zz.server.controller.UserController;

public class RequestHandler {
    public void handle(Connector connector){
        String token = connector.readLine();
        String action = connector.readLine();
        String data = connector.readLine();

//        System.out.println(action);
//        System.out.println(data);

        Request request = new Request();

        request.setAction(action);
        request.setData(data);

        Response response = new Response();

        if(action.equals("add")){
            new TodoListController().add(request, response);
        }else if (action.equals("get")){
            new TodoListController().get(request, response);
        }else if (action.equals("set")) {
            new TodoListController().set(request, response);
        }else if (action.equals("delete")) {
            new TodoListController().delete(request, response);
        }else if(action.equals("register")){
            new UserController().register(request, response);
        }else if (action.equals("user add")){
            new UserController().add(request, response);
        }else if (action.equals("user login")){
            new UserController().login(request, response);
        }else {
            Long userId = new UserService().checkAuthentication(token);

            if (userId == null)
                response.setStatus(Response.failure);
            else{
                if (action.equals("todo get all")){
                    new TodoItemController().getAll(request, response);
                }
            }


        }


        connector.writeLine(response.getStatus());
        connector.writeLine(response.getData());


    }
}
