package zz.client.service;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import zz.client.net.RequestSender;
import zz.common.model.TodoItem;
import zz.common.net.Request;
import zz.common.net.Response;

import java.util.LinkedList;
import java.util.List;

public class TodoItemService {

    public List<TodoItem> get(){
        Request request = new Request();
        request.setAction("todo get all");

        Response response = new RequestSender().send(request);
        String data = response.getData();

        System.out.println(data);
        Gson gson = new Gson();
        LinkedList<LinkedTreeMap<String,String>> linkedList =
                gson.fromJson(data, LinkedList.class);

        return null;
    }

    public static void main(String[] args) {
        new UserService().login("a", "b");
        List<TodoItem> todoItems = new TodoItemService().get();
        System.out.println(todoItems);

    }
}
