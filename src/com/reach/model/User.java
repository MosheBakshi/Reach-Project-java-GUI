package com.reach.model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class User implements Serializable,Model {

    public User() {}
    protected String userName;
    protected String lname;
    protected String fname;
    protected UserType userType;
    protected int userId;
    protected int userCell;
    protected String userCity;
    protected ArrayList<Job> jobs;
    protected ArrayList<Job> jobsHistory;
    protected Rating rating;
    protected ArrayList<Review> review = new ArrayList<>();

    // Setters
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

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public void setUserCell(int userCell) {
        this.userCell = userCell;
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

    public String getFname() {
        return fname;
    }

    public Rating getRating() {
        return rating;
    }

    public int getUserId() {
        return userId;
    }

    public int getUserCell() {
        return userCell;
    }

    public String getLname() {
        return lname;
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
}

/*public void setName() {
        Scanner userchoice = new Scanner(System.in);
        System.out.println("Enter your first name please: ");
        String str= userchoice.nextLine();
        name = str;
        System.out.println("Enter your last name please: ");
        str= userchoice.nextLine();
        lname = str;
        System.out.println("You entered: " + name + " " + lname);
    }
    public userT setType() {
        Scanner userchoice = new Scanner(System.in);
        System.out.println("Please choose you user type: ");
        System.out.println("                             1) Customer ");
        System.out.println("                             2) Freelancer ");
        System.out.println("                             3) Contractor ");
        int i = userchoice.nextInt();
        switch(i) {
            case 1:
                this.userType = userT.customer;
                break;
            case 2:
                this.userType = userT.freelancer;
                break;
            case 3:
                this.userType = userT.contractor;
                break;
        }
        System.out.println("Your choice is: "
                + this.userType.toString().toUpperCase().charAt(0)
                +  this.userType.toString().substring(1));
        return userType;
    }
    public void setId() {
        Scanner userchoice = new Scanner(System.in);
        System.out.println("Enter your ID please: ");
        int str= userchoice.nextInt();
        this.userId = str;
        System.out.println("Your ID is: " + userId);
    }
    public void setCell() {
        Scanner userchoice = new Scanner(System.in);
        System.out.println("Enter your Cellphone number please: ");
        int str= userchoice.nextInt();
        this.userCell = str;
        System.out.println("Your ID is: " + userCell);
    }
    public void setCity() {
        Scanner userchoice = new Scanner(System.in);
        System.out.println("Enter your city please: ");
        String str= userchoice.nextLine();
        this.userCity = str;
        System.out.println("Your city is: " + userCity);
    }*/