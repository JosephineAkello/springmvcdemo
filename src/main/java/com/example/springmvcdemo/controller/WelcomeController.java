package com.example.springmvcdemo.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public class WelcomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showLoginPage(ModelMap modelMap) {
       modelMap.put("name", "in28minutes");
        return "welcome";
    }

}
