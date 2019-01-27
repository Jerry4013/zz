package zz.client.service;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import zz.client.net.RequestSender;
import zz.common.model.TodoItem;
import zz.common.model.TodoList;
import zz.common.net.Request;
import zz.common.net.Response;

public class TodoListService {
    public void add(TodoItem item){
        Request request = new Request();
        request.setAction("add");

        String data = new Gson().toJson(item);
        request.setData(data);

        new RequestSender().send(request);
    }

    public void delete(int index){
        Request request = new Request();
        request.setAction("delete");

        String data = new Gson().toJson(index);
        request.setData(data);

        new RequestSender().send(request);
    }

    public void set(int index, TodoItem item){
        Request request = new Request();
        request.setAction("set");

        JsonArray jsonElements = new JsonArray();
        jsonElements.add(index);
        jsonElements.add(item.getText());
        String data = new Gson().toJson(jsonElements);
        request.setData(data);

        new RequestSender().send(request);
    }

    public TodoList get() {
        Request request = new Request();
        request.setAction("get");

        Response response = new RequestSender().send(request);

        String data = response.getData();

        TodoList todoList = new Gson().fromJson(data, TodoList.class);

        return todoList;
    }
}
