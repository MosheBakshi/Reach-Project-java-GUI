package com.reach.controller;

import com.reach.model.Model;
import com.reach.view.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class MyController {
    private View view;
    private Model model;

    public MyController(View view, Model model) {
        this.view = view;
        this.model = model;
    }

}

