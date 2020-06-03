package com.reach.controller;

import com.reach.model.*;
import com.reach.view.ReviewScreen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyController {

    private static final MyController instance = new MyController();
    private CreateUser using = new CreateUser();
    private WriterReader readWrite = new WriterReader();

    //constructor for singelton
    private MyController(){}

    //Method for return the instance of singelton
    public static MyController getInstance(){return instance;}

    //Method for verify the user name and password
    public boolean verifyUserNameAndPassword(String userName,String password)
    {
        if(WriterReader.verify(userName,password))
            return true;
        else
            return false;
    }

    //called on click "Write review" from JobScreen
    public void writeReview(String userName, String workerUserName)
    {
        ReviewScreen v = new ReviewScreen();
        v.showScreen(/*userName,workerUserName*/);
    }

    //called on click confirm from ReviewScreen
    public static void createReview(String userName, int id, double cost, double deadline, double quality)
    {
        Review newReview = new Review(userName,id,cost,deadline,quality);
        //call publishReview
    }

    //called to add review to list after review made
    public void publishReview(Review review, String workerUserName)
    {
        readWrite.UsersHM.get(workerUserName).setReview(review);
    }

    public int getUserId(String userName)
    {
       return WriterReader.load(userName).getUserId();
    }

    public ArrayList<Job> getUserJobs(String userName)
    {
       return WriterReader.load(userName).getJobs();
    }

    public ArrayList<Job> getUserJobHistory(String userName)
    {
       return WriterReader.load(userName).getJobsHistory();
    }

    public List<User> getResults(String prof,String area)
    {
        List<User> results = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(readWrite.UsersHM.keySet());
        for(int i = 0; i< keys.size(); i++)
        {
            if((readWrite.UsersHM.get(keys.get(i)).getUserType()==UserType.contractor||
                    readWrite.UsersHM.get(keys.get(i)).getUserType()==UserType.freelancer)&&
                    (((Contractor)readWrite.UsersHM.get(keys.get(i))).getField().equals(prof))&&
                    ((Contractor)readWrite.UsersHM.get(keys.get(i))).getArea().equals(area))

                results.add(readWrite.UsersHM.get(keys.get(i)));
        }
        return results;
    }

}




