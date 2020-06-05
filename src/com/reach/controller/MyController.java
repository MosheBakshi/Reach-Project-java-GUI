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
    public boolean verifyUserNameAndPassword(String userName,String password) {
        if(WriterReader.verify(userName,password))
            return true;
        else
            return false;
    }

    //called on click "Write review" from JobScreen
    public void writeReview(String userName, String workerUserName) {
        ReviewScreen v = new ReviewScreen();
        v.showScreen(/*userName,workerUserName*/);
    }

    //called on click confirm from ReviewScreen
    public static void createReview(String userName, int id, double cost, double deadline, double quality) {
        Review newReview = new Review(userName,id,cost,deadline,quality);
        //call publishReview
    }

    //called to add review to list after review made
    public void publishReview(Review review, String workerUserName) {
        readWrite.UsersHM.get(workerUserName).setReview(review);
    }

    public int getUserId(String userName)
    {
        return WriterReader.load(userName).getUserId();
    }

    public int getUserJobsSize(String userName) {
        if(WriterReader.load(userName).getJobs()!=null)
            return WriterReader.load(userName).getJobs().size();
        else return 0;
    }

    public int getUserJobHistorySize(String userName){
        if(WriterReader.load(userName).getJobsHistory().isEmpty())
            return 0;
        else return WriterReader.load(userName).getJobsHistory().size();
    }

    public  String HistoryDescription(String userName, int i){
        return WriterReader.load(userName).getJobsHistory().get(i).getDescription();
    }

    public  String JobDescription(String userName, int i){
        return WriterReader.load(userName).getJobs().get(i).getDescription();
    }

    public  int HistoryID(String userName, int i){
        return WriterReader.load(userName).getJobsHistory().get(i).getId();
    }

    public  int JobID(String userName, int i){
        return WriterReader.load(userName).getJobs().get(i).getId();
    }

    public int getResultsSize(String prof,String area){
        List<User> results = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(readWrite.UsersHM.keySet());
        for (String key : keys)
        {
            if ((readWrite.UsersHM.get(key).getUserType() == UserType.contractor ||
                    readWrite.UsersHM.get(key).getUserType() == UserType.freelancer) &&
                    (((Contractor) readWrite.UsersHM.get(key)).getField().equals(prof)) &&
                    ((Contractor) readWrite.UsersHM.get(key)).getArea().equals(area))

                results.add(readWrite.UsersHM.get(key));
        }
        if(results.size()>0)
            return results.size();
        else return 0;
    }

    public String getResultsName(String prof,String area,int i) {
        List<User> results = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(readWrite.UsersHM.keySet());
        for (String key : keys)
        {
            if ((readWrite.UsersHM.get(key).getUserType() == UserType.contractor ||
                    readWrite.UsersHM.get(key).getUserType() == UserType.freelancer) &&
                    (((Contractor) readWrite.UsersHM.get(key)).getField().equals(prof)) &&
                    ((Contractor) readWrite.UsersHM.get(key)).getArea().equals(area))

                results.add(readWrite.UsersHM.get(key));
        }
        return results.get(i).getFirstName();
    }

    public String getResultsSub(String prof, String area, int i) {
        List<User> results = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(readWrite.UsersHM.keySet());
        for (String key : keys)
        {
            if ((readWrite.UsersHM.get(key).getUserType() == UserType.contractor ||
                    readWrite.UsersHM.get(key).getUserType() == UserType.freelancer) &&
                    (((Contractor) readWrite.UsersHM.get(key)).getField().equals(prof)) &&
                    ((Contractor) readWrite.UsersHM.get(key)).getArea().equals(area))

                results.add(readWrite.UsersHM.get(key));
        }
        return ((Contractor)results.get(i)).getSubfield();
    }

    public double getResultsRating(String prof, String area, int i) {
        List<User> results = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(readWrite.UsersHM.keySet());
        for (String key : keys)
        {
            if ((readWrite.UsersHM.get(key).getUserType() == UserType.contractor ||
                    readWrite.UsersHM.get(key).getUserType() == UserType.freelancer) &&
                    (((Contractor) readWrite.UsersHM.get(key)).getField().equals(prof)) &&
                    ((Contractor) readWrite.UsersHM.get(key)).getArea().equals(area))

                results.add(readWrite.UsersHM.get(key));
        }
        return ((Contractor)results.get(i)).getRating();
    }
}




