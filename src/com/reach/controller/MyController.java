package com.reach.controller;
import com.reach.model.CreateUser;
import com.reach.model.Model;
import com.reach.model.User;
import com.reach.model.WriterReader;

public class MyController {
    private static final MyController instance=new MyController();
    private CreateUser using = new CreateUser();
    private WriterReader setObject = new WriterReader();

    //constructor for singelton
    private MyController(){}

    //Method for return the instance of singelton
    public static MyController getInstance(){return instance;}

    //Method for verify the user name and password
    public boolean verifyUserNameAndPassword(String userName,String password){
        if(WriterReader.verify(userName,password))
            return true;
        else
            return false;
    }
}


