package com.reach.model;

public class CreateUser {
    public CreateUser(){
    }
    public User createUser(String choice,String userName)
    {
        switch (choice){
            case "Consumer":
                return new Customer(UserType.customer,userName);
            case "Contractor":
                return new Contractor(UserType.contractor,userName);
            case "Freelancer":
                return new Freelancer(UserType.freelancer,userName);
        }
        return null;
    }
}
