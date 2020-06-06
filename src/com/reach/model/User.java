package com.reach.model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable,Model {

    public User() {}

    protected String userName;
    protected String lastName;
    protected String firstName;
    private String Password;
    protected UserType userType;
    protected int userId;
    protected String phone;
    protected String userCity;
    protected ArrayList<Job> jobs = new ArrayList<>();
    protected ArrayList<Job> jobsHistory = new ArrayList<>();
    protected Rating rating;
    protected ArrayList<Review> review = new ArrayList<>();

    // Setters
    public void setPassword(String password) {
        Password = password;
    }

    public void setReview(Review review) {
        this.review.add(review);
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setJobs(ArrayList<Job> jobs) {
        this.jobs = jobs;
    }

    public void setJobsHistory(ArrayList<Job> jobsHistory) {
        this.jobsHistory = jobsHistory;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUserCity(String userCity) {
        this.userCity = userCity;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void addJob(int id,String description,String title, String deadline, String date, Price price){
        Job newOne = new Job();
        newOne.setId(id); // for customer /// temporarlly its by customer id should be fixed to job id
        newOne.setTitle(title); // job title
        newOne.setDescription(description); // job description;
        newOne.setDeadline(deadline); // job deadline XX/XX/XXXX
        newOne.setDate(date); // job Start Date XX/XX/XXXX
        newOne.setPrice(price); // set in the constructor of job.price
        jobs.add(newOne);
    }

    public void editJob(int id,String description,String title, String deadline, String date, Price price){
        Job index = new Job();
        for(int i = 0; i<this.jobs.size(); i++)
        {
            index = jobs.get(i);
            if(id == index.getId())
            {
                index.setId(id); // for customer /// temporarlly its by customer id should be fixed to job id
                index.setTitle(title); // job title
                index.setDescription(description); // job description;
                index.setDeadline(deadline); // job deadline XX/XX/XXXX
                index.setDate(date); // job Start Date XX/XX/XXXX
                index.setPrice(price); // set in the constructor of job.price
                jobs.set(i,index);
                break;
            }
        }
        //System.out.print("ID wasn't found");
    }

    public void closeJob(int id){
        Job index = new Job();
        for(int i = 0; i<this.jobs.size(); i++)
        {
            index = jobs.get(i);
            if(id == index.getId())
            {
                jobsHistory.add(index);
                jobs.remove(i);
                break;
            }
        }
    }

    // getters
    public ArrayList<Job> getJobs() {
        return jobs;
    }

    public ArrayList<Review> getReview() {
        return review;
    }

    public ArrayList<Job> getJobsHistory() {
        return jobsHistory;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getRating() {
        return rating.avgRate;
    }

    public int getUserId() {
        return userId;
    }

    public String getPhone() {
        return phone;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserCity() {
        return userCity;
    }

    public UserType getUserType() {
        return userType;
    }

    public String getPassword() {
        return Password;
    }
}
