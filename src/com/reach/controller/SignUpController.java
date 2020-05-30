package com.reach.controller;

import com.reach.model.CreateUser;
import com.reach.model.User;

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
