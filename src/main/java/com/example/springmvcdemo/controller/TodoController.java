package com.example.springmvcdemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import com.example.springmvcdemo.model.Todo;
import com.example.springmvcdemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class TodoController {

    @Autowired
    TodoService service;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat, false));
    }

                         @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String listTodos(ModelMap model) {
        model.addAttribute("todos", service.retrieveTodos(getUserData()));
        return "list-todos";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showTodoPage(ModelMap model) {
        model.addAttribute("todo", new Todo(0,
                getUserData(),
                "",
                new Date(),
                false));
        return "todo";
    }

    private String getUserData() {
        Object principal = SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        if(principal instanceof UserDetails)
            return ((UserDetails) principal).getUsername();

        return principal.toString();
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


    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String updateTodoPage(ModelMap model, @RequestParam int id) {
        Todo todo = service.retrieveTodo(id);
        model.addAttribute("todo", todo);
        return "todo";
    }
    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodoPage(ModelMap model, @Valid Todo todo, BindingResult result) {
        if (result.hasErrors()) {
            return "todo";
        }
        todo.setUser((String) model.get("name"));
        service.updateTodo(todo);
        return "redirect:list-todos";
    }
    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodoPage(ModelMap model, @RequestParam int id) {
        service.deleteTodo(id);
        model.clear();
        return "redirect::list-todo";
    }
}
