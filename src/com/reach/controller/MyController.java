package com.reach.controller;

import com.reach.model.CreateUser;
import com.reach.model.Model;
import com.reach.model.User;
import com.reach.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class MyController {
    private View view;
    private Model model;
    private CreateUser using = new CreateUser();

    public MyController(String choice,String uname){
        using.createUser(choice,uname);
    }
    public MyController(View view, Model model) {
        this.view = view;
        this.model = model;
    }
    public void printScreen(){
        view.showScreen();
    }
}

