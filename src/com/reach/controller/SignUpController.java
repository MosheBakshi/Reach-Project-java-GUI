package com.reach.controller;

import com.reach.model.CreateUser;
import com.reach.model.Model;
import com.reach.model.User;
import com.reach.view.SignUpScreen;
import com.reach.view.View;

public class SignUpController {
    private static final SignUpController instance = new SignUpController();
    // SingleTone implementation //
    private SignUpController(){}
    public static SignUpController getInstance(){return instance;}

    // User Creator API//
    public User createUser(String choice, String userName,String PrivateName,String LastName, String Password){
        User newOne = new CreateUser().createUser(choice,userName,PrivateName,LastName,Password);
        return newOne;
    }
}
