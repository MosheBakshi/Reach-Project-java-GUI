package com.reach.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class User implements Serializable {
    public User() {}
    protected String username;
    protected String password;
    protected String fname;
    protected String lname;
    protected userT userType;
    protected int userId;
    protected String userCell;
    protected String userCity;
    protected ArrayList<Job> jobs;
    protected ArrayList<Job> jobsHistory;
    protected Rating rating;
    protected ArrayList<Review> review;
    // add setter and getters for rating and review list
    // Setters
    public void setUsername(String userN) {
       username = userN;
    }
    public void setType() {
      // not initialized yet
    }
    public void setId(int id) {
       userId = id;
    }
    public void setCell(String cell) {
        userCell = cell;
    }
    public void setCity(String city) {
    userCity = city;
    }
    public void setPassword(String pass) {
        password = pass;
    }
    // getters
    public void addJob(int customerID){
        Job newOne = new Job();
        Scanner userChoice = new Scanner (System.in);
        String iNside;
        newOne.setId(customerID); // for customer
        iNside = userChoice.next();
        newOne.setTitle(iNside); // job title
        iNside = userChoice.next();
        newOne.setDescription(iNside); // job description
        iNside = userChoice.next();
        newOne.setDeadline(iNside); // job deadline XX/XX/XXXX
        iNside = userChoice.next();
        newOne.setDate(iNside); // job Start Date XX/XX/XXXX
        newOne.setPrice(); // set in the constructor of job.price

        jobs.add(newOne);
    }

    public void editJob(int customerID){
        Job index = new Job();
        for(int i = 0; i<this.jobs.size(); i++){
            index = jobs.get(i);
            if(customerID == index.getId()){

                Scanner userChoice = new Scanner (System.in);
                String iNside;
                index.setId(customerID); // for customer /// temporarlly its by customer id should be fixed to job id
                iNside = userChoice.next();
                index.setTitle(iNside); // job title
                iNside = userChoice.next();
                index.setDescription(iNside); // job description
                iNside = userChoice.next();
                index.setDeadline(iNside); // job deadline XX/XX/XXXX
                iNside = userChoice.next();
                index.setDate(iNside); // job Start Date XX/XX/XXXX
                index.setPrice(); // set in the constructor of job.price
                jobs.set(i,index);
            }
        }
        System.out.print("ID wasn't found");
    }

    public void closeJob(int customerID){
        Job index = new Job();
        for(int i = 0; i<this.jobs.size(); i++){
            index = jobs.get(i);
            if(customerID == index.getId()){
                jobsHistory.add(index);
                jobs.remove(i);
            }
        }
    }

    public int getUserId() {
        return userId;
    }

    public String getUserCell() {
        return userCell;
    }

    public String getLname() {
        return lname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() { return password; }

    public String getUserCity() {
        return userCity;
    }

    public userT getUserType() {
        return userType;
    }
}
