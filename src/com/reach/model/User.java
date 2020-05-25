package com.reach.model;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class User {
    public User() {}
    protected String name;
    protected String lname;
    protected userT userType;
    protected int userId;
    protected int userCell;
    protected String userCity;
    protected ArrayList<Job> jobs;
    protected ArrayList<Job> jobsHistory;
    protected Rating rating;
    protected ArrayList<Review> review;
    // add setter and getters for rating and review list
    // Setters
    public void setName() {
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

    public int getUserCell() {
        return userCell;
    }

    public String getLname() {
        return lname;
    }

    public String getName() {
        return name;
    }

    public String getUserCity() {
        return userCity;
    }

    public userT getUserType() {
        return userType;
    }
}
