package com.reach.model;

public class Customer extends User{
    // inherence from User class
    public Customer(userT choice)
    {this.userType = choice;System.out.println(" constructor called ! user type: " + this.userType);}
}
