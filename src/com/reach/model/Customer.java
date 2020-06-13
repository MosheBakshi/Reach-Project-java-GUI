package com.reach.model;

public class Customer extends User implements Model{

    // inherence from User class
    public Customer(UserType choice, String userName, String PrivateName, String LastName, String Password) {
        this.userType = choice;
        System.out.println(" constructor called ! user type: " + this.userType);

        setUserName(userName);
        setFirstName(PrivateName);
        setLastName(LastName);
        setPassword(Password);
    }
    @Override
    public UserType getUserType() {
        return UserType.customer;
    }
}
