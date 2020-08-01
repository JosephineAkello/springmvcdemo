package com.example.springmvcdemo.controller;

import com.example.springmvcdemo.service.LoginService;
import com.example.springmvcdemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodoController {

   @Autowired
   TodoService service;

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String handleLoinRequest(@RequestParam String name, ModelMap model){
        model.addAttribute("todos", service.retrieveTodos("user"));
        return "welcome";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String handleLoginRequest(@RequestParam String name, ModelMap model){
       model.addAttribute("todos", service.retrieveTodos("user"));
        return "welcome";
    }
}
