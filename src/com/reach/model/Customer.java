package com.reach.model;

public class Customer extends User{

    // inherence from User class
    public Customer(userT choice,String uname) {
        this.userType = choice;
        setUsername(uname);
    }

    public Customer(userT customer) {
    }
}
