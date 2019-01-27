package zz.server.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import zz.common.model.User;
import zz.common.net.Request;
import zz.common.net.Response;
import zz.server.service.UserService;

public class UserController {

    private UserService service = new UserService();

    public boolean register(Request request, Response response){
        Gson gson = new Gson();

        JsonArray jsonElements = gson.fromJson(request.getData(), JsonArray.class);
        JsonElement e1 = jsonElements.get(0);
        JsonElement e2 = jsonElements.get(1);
        String username = e1.getAsString();
        String password = e2.getAsString();

        boolean result =  service.register(username, password);
        if (result){
            response.setStatus("success");
            return true;
        }
        else {
            response.setStatus("fail");
            return false;
        }
    }

    public void add(Request request, Response response){
        Gson gson = new Gson();
        User user = gson.fromJson(request.getData(), User.class);
        boolean success = service.register(user.getUsername(), user.getPassword());
        String status = success ? Response.success : Response.failure;
        response.setStatus(status);
    }

    public void login(Request request, Response response){
        Gson gson = new Gson();
        User user = gson.fromJson(request.getData(), User.class);

        String token = service.login(user.getUsername(), user.getPassword());

        if (token == null) {
            response.setStatus(Response.failure);
            return;
        }

        response.setStatus(Response.success);
        response.setData(token);
    }
}
