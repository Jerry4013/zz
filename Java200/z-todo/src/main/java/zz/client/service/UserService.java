package zz.client.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import zz.client.net.RequestSender;
import zz.common.model.User;
import zz.common.net.Request;
import zz.common.net.Response;

public class UserService {
    
    public static String authentication = null;
    public boolean register(String username, String password){
        Request request = new Request();
        request.setAction("user add");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        String json = new Gson().toJson(user);
        request.setData(json);

//        JsonObject object = new JsonObject();
//        object.addProperty("username", username);
//        object.addProperty("password", password);

//        JsonArray jsonElements = new JsonArray();
//        jsonElements.add(username);
//        jsonElements.add(password);
//        String data = new Gson().toJson(jsonElements);

        Response response = new RequestSender().send(request);

        return  response.isSuccess();
    }

    public boolean login(String username, String password){
        Request request = new Request();
        request.setAction("user login");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);

        String json = new Gson().toJson(user);
        request.setData(json);

        Response response = new RequestSender().send(request);

        if (!response.isSuccess()) {
            return false;
        }

        String token = response.getData();
        UserService.authentication = token;
        return true;
    }

    public static void main(String[] args) {
        //        new UserService().register("a", "b");
        boolean login = new UserService().login("a", "b");
        System.out.println(login);
        System.out.println(UserService.authentication);
    }
}
