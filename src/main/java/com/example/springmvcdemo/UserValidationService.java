package com.example.springmvcdemo;

public class UserValidationService {
    public boolean isUserValid(String user, String password){
        if(user.equals("nnnnnn") && password.equals("dummy"))
            return true;

        return false;
    }
}
