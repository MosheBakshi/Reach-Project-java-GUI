package com.reach.model;

public class Price implements Model{

    protected String jobType;
    protected double jobCost;

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public void setJobCost(double jobCost) {
        this.jobCost = jobCost;
    }

    public String getJobType() {
        return jobType;
    }

    public double getJobCost() {
        return jobCost;
    }
}
