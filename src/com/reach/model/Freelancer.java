package com.reach.model;

public class Freelancer extends User implements  Model{

    protected String field;
    protected String subfield;
    protected int yearsOfexperience;
    protected String area; // can be as the enum in the User file.
    protected String availability;

    public Freelancer(UserType choice, String userName, String PrivateName, String LastName, String Password) {
        this.userType = choice;
        System.out.println(" constructor called ! user type: " + this.userType);
        setUserName(userName);
        setFirstName(PrivateName);
        setLastName(LastName);
        setPassword(Password);
    }

    @Override
    public UserType getUserType() {
        return UserType.freelancer;
    }

    public String getField() {
        return field;
    }

    public String getSubfield() {
        return subfield;
    }

    public String getArea() {
        return area;
    }
}