package com.reach.model;

public class Freelancer extends User implements  Model{

    protected String field;
    protected String subfield;
    protected int yearsOfexperience;
    protected String area; // can be as the enum in the User file.
    protected String availability;

    public Freelancer(UserType choice,String userName) {
        this.userType = choice; System.out.println(" constructor called ! user type: " + this.userType);
        setUserName(userName);
    }

    @Override
    public UserType getUserType() {
        return UserType.freelancer;
    }

}