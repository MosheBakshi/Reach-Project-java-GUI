package com.reach.model;

public class Review {

    protected String review;
    protected int user_id;
    protected double rateCost;
    protected double rateDeadline;
    protected double rateQuality;

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setRateCost(double rateCost) {
        this.rateCost = rateCost;
    }

    public void setRateDeadline(double rateDeadline) {
        this.rateDeadline = rateDeadline;
    }

    public void setRateQuality(double rateQuality) {
        this.rateQuality = rateQuality;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public int getUser_id() {
        return user_id;
    }

    public double getRateCost() {
        return rateCost;
    }

    public double getRateDeadline() {
        return rateDeadline;
    }

    public double getRateQuality() {
        return rateQuality;
    }

    public String getReview() {
        return review;
    }

}


/*public Review setReview(int user_id){
        double num;
        Review rev = new Review();
        Scanner n = new Scanner(System.in);

        setUser_id(user_id);

        System.out.println("Enter a verbal review for the job done for you: \n");
        n.next();
        rev.setReview(n.toString());

        System.out.println("Rate from 1 to 5 how pleased are you with the cost: \n");
        n.next();
        num=Integer.parseInt(n.toString());
        if(num > 5)
            num = 5;
        else if(num < 1)
            num = 1;
        rev.setRateCost(num);

        System.out.println("Rate from 1 to 5 how pleased are you with the deadline: \n");
        n.next();
        num=Integer.parseInt(n.toString());
        if(num > 5)
            num = 5;
        else if(num < 1)
            num = 1;
        rev.setRateCost(num);

        System.out.println("Rate from 1 to 5 how pleased are you with the quality: \n");
        n.next();
        num=Integer.parseInt(n.toString());
        if(num > 5)
            num = 5;
        else if(num < 1)
            num = 1;
        rev.setRateCost(num);

        return rev;
    }*/
