package zz.server.controller;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import zz.common.model.TodoItem;
import zz.common.model.TodoList;
import zz.common.net.Request;
import zz.common.net.Response;
import zz.server.service.TodoListService;

public class TodoListController {

    private TodoListService service = new TodoListService();

    public void add(Request request, Response response){
        Gson gson = new Gson();
        TodoItem todoItem = gson.fromJson(request.getData(), TodoItem.class);

        service.add(todoItem);

        response.setStatus("success");
    }

    public void get(Request request, Response response){
        TodoList todoList = service.get();

        response.setStatus("success");

        String data = new Gson().toJson(todoList);
        response.setData(data);
    }

    public void set(Request request, Response response){
        Gson gson = new Gson();

        JsonArray jsonElements = gson.fromJson(request.getData(), JsonArray.class);
        JsonElement e1 = jsonElements.get(0);
        JsonElement e2 = jsonElements.get(1);
        int index = e1.getAsInt();
        TodoItem item = new TodoItem(e2.getAsString());

        service.set(index, item);

        response.setStatus("success");
    }

    public void delete(Request request, Response response){
        Gson gson = new Gson();
        Integer index = gson.fromJson(request.getData(), Integer.class);

        service.delete(index);

        response.setStatus("success");
    }
}