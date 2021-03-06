package com.example.springmvcdemo.controller;

import java.util.List;

import com.example.springmvcdemo.model.Todo;
import com.example.springmvcdemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoRestController {

    @Autowired
    TodoService service;

    @RequestMapping(value = "/todo/", method = RequestMethod.GET)
    public List<Todo> listAllTodos() {
        List<Todo> users = service.retrieveTodos("in28Minutes");
        return users;
    }

    @RequestMapping(value = "/todo/{id}", method = RequestMethod.GET)
    public Todo retrieveTodo(@PathVariable("id") int id) {
        return service.retrieveTodo(id);
    }
}
