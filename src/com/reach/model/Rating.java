package com.reach.model;

import java.util.ArrayList;

public class Rating {

    protected double avgRate;
    protected double avgRateCost;
    protected double avgRateDeadline;
    protected double avgRateQuality;
    protected ArrayList<Review> reviews = new ArrayList<>();

    public void setAvgRate(double avgRate) {
        this.avgRate = avgRate;
    }

    public void setAvgRateCost(double avgRateCost) {
        this.avgRateCost = avgRateCost;
    }

    public void setAvgRateDeadline(double avgRateDeadline) {
        this.avgRateDeadline = avgRateDeadline;
    }

    public void setAvgRateQuality(double avgRateQuality) {
        this.avgRateQuality = avgRateQuality;
    }

    public void setReviews(ArrayList<Review> reviews) {
        this.reviews = reviews;
    }

    public ArrayList<Review> getReviews() {
        return reviews;
    }

    public double getAvgRate() {
        return avgRate;
    }

    public double getAvgRateCost() {
        return avgRateCost;
    }

    public double getAvgRateDeadline() {
        return avgRateDeadline;
    }

    public double getAvgRateQuality() {
        return avgRateQuality;
    }

    public void setAvgs() {
        double sumcost = 0, sumdeadline = 0, sumquality = 0;
        for (int i=0; i<this.reviews.size();i++)
        {
            Review rev = reviews.get(i);
            sumcost+=rev.getRateCost();
            sumdeadline+=rev.getRateDeadline();
            sumquality+=rev.getRateQuality();
        }
        this.setAvgRateCost(sumcost / reviews.size());
        this.setAvgRateDeadline(sumdeadline / reviews.size());
        this.setAvgRateQuality(sumquality / reviews.size());
        this.setAvgRate((this.getAvgRateCost() + this.getAvgRateDeadline() + this.getAvgRateQuality()) / 3);
    }
}
