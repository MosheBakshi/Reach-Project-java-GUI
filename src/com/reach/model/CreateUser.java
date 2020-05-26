package com.reach.model;

import javax.swing.*;

public class CreateUser {
    public CreateUser(){
    }
    public User createUser(String choice,String uname){
        switch (choice){
            case "Consumer":
                JOptionPane.showMessageDialog(null, uname);
                return new Customer(userT.customer,uname);
            case "Contractor":
                return new Contractor(userT.contractor);
            case "Freelancer":
                return new Freelancer(userT.contractor);
        }
        return null;
    }
}
