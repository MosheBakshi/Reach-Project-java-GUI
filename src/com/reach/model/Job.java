package com.reach.model;

import java.io.Serializable;

public class Job implements Serializable,Model{
    protected int id;
    protected String description;
    protected String customerUserName;
    protected String workerUserName;
    protected String title;
    protected String date;
    protected String deadline;
    protected Price Price;
    protected Boolean accepted = false;

    public Job(String CusUserName,String WorkUserName,String desc){
        customerUserName = CusUserName;
        workerUserName = WorkUserName;
        description = desc;
    }


    public String getWorkerUserName() {
        return workerUserName;
    }

    public void setWorkerUserName(String workerUserName) {
        this.workerUserName = workerUserName;
    }

    public void setCustomerUserName(String name) {
        this.customerUserName = name;
    }

    public String getCustomerUserName() {
        return customerUserName;
    }

    public void setAccepted(){
        accepted = !accepted;
    }

    public int getId() {
        return id;
    }

    public Boolean getAccepted(){return accepted;}

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
        return this.description;
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
