package com.reach.model;

import java.util.ArrayList;
import java.util.Scanner;

public class Job {
    protected int id;
    protected String description;
    protected String customerName;
    protected String contractorName;
    protected ArrayList<String> freelancers;
    protected String title;
    protected String date;
    protected String deadline;
    protected Price Price;

    public void setContractorName(String name) {
        this.contractorName = name;
    }

    public void setCustomerName(String name) {
        this.customerName = name;
    }

    public void setFreelancers(String name) {
        this.freelancers.add(name);
    }

    public ArrayList<String> getFreelancers() {
        return freelancers;
    }

    public String getContractorName() {
        return contractorName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public Price getPrice() {
        return Price;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPrice(Price price){
        this.Price=price;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

/*public void setPrice() {
        Price = new Price();
        Scanner userChoice = new Scanner(System.in);
        String iNside;
        double price;
        iNside = userChoice.next();
        Price.setJobType(iNside); // job type set
        price = userChoice.nextDouble();
        Price.setJobCost(price);
    }*/