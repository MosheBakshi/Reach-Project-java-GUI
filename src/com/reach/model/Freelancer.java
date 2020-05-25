package com.reach.model;

public class Freelancer extends User {
    protected String field;
    protected int yearsOfexperience;
    protected String area; // can be as the enum in the User file.
    protected String availability;
    public Freelancer(userT choice) {this.userType = choice; System.out.println(" constructor called ! user type: " + this.userType);}
}
