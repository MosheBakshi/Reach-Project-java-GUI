package com.reach.model;

public class Customer extends User implements Model{

    // inherence from User class
    public Customer(UserType choice, String userName) {
        this.userType = choice;
        setUserName(userName);
    }

    @Override
    public UserType getUserType() {
        return UserType.customer;
    }
}
