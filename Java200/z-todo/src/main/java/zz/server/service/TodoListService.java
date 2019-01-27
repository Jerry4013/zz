package zz.server.service;

import zz.common.model.TodoList;
import zz.common.model.TodoItem;
import zz.server.persistence.TodoListPersistence;
import zz.server.persistence.TodoListPersistenceJson;


public class TodoListService {

    // in memory model

    private TodoListPersistence persistence = new TodoListPersistenceJson();
    //services

    public void add(TodoItem item){
        TodoList todoList = get();
        todoList.getItems().add(item);
        persistence.save(todoList);
    }

    public void delete(int index){
        TodoList todoList = get();
        todoList.getItems().remove(index);
        persistence.save(todoList);
    }

    public void set(int index, TodoItem item){
        TodoList todoList = get();
        todoList.getItems().set(index,item);
        persistence.save(todoList);
    }

    public TodoList get() {
        TodoList todoList = persistence.read();
        if (todoList == null) {
            todoList = new TodoList();
            todoList.setTitle("My Todo List");
            persistence.save(todoList);
        }
        return todoList;
    }

}
