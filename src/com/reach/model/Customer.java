package com.reach.model;

public class Customer extends User{
    WriterReader setObject = new WriterReader();
    // inherence from User class
    public Customer(userT choice,String uname) {
        this.userType = choice;
        setUsername(uname);
        setObject.save(this);
    }
}
