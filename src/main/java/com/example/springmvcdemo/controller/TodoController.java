package com.example.springmvcdemo.controller;

import java.util.Date;

import javax.validation.Valid;

import com.example.springmvcdemo.model.Todo;
import com.example.springmvcdemo.service.LoginService;
import com.example.springmvcdemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService service;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String listTodos(ModelMap model) {
        model.addAttribute("todos", service.retrieveTodos("user"));
        return "list-todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo(0,
                "in28minutes","", new Date(), false));
        return "todo";
    }


    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String addTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
            service.addTodo("in28mintes", todo.getDesc(), new Date(), false);

        model.clear();
        return "redirect::list-todo";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodoPage(ModelMap model, @RequestParam int id) {
        service.deleteTodo(id);
        model.clear();
        return "redirect::list-todo";
    }
}
