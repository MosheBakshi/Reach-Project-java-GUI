package com.reach.controller;

import com.reach.model.*;
import com.reach.view.MainPanel;
import com.reach.view.ReviewScreen;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MyController {

    private static final MyController instance = new MyController();
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
        return WriterReader.UsersHM.get(userName).getUserId();
    }

   public UserType getUserType(String userName){
        return WriterReader.getUserType(userName);
    }

    public String getFirstName(String username) {
        return WriterReader.getFirstName(username);
    }

    public String getLastName(String username) {
        return WriterReader.getLastName(username);
    }

    public String getPhone(String userName) {
        return WriterReader.getPhone(userName);
    }

    public void setPhone(String userName ,String phone) {
        WriterReader.setPhone(userName , phone);
    }

    public void setCity(String userName, String city) {
        WriterReader.setCity(userName,city);
    }

    public String getCity(String username) {
        return WriterReader.getCity(username);
    }

    public String getExperience(String username) {
        return WriterReader.getExperience(username);
    }

    public String getArea(String username) {
        return WriterReader.getArea(username);
    }

    public void setExperience(String userName, String experience) {
        WriterReader.setExperience(userName,experience);
    }

    public String  getField(String userName) {
        return WriterReader.getField(userName);
    }

    public void setField(String userName, String enterF) {
        WriterReader.setField(userName,enterF);
    }

    public void setSubfield(String userName, String subfield) {
        WriterReader.setSubfield(userName,subfield);
    }

    public String getSubfield(String username) {
        return WriterReader.getSubfield(username);
    }

    public void setArea(String userName, String chooseArea) {
        WriterReader.setArea(userName,chooseArea);
    }

    public int getUserJobsSize(String userName){
        if(WriterReader.UsersHM.get(userName).getJobs()!=null)
            return WriterReader.UsersHM.get(userName).getJobs().size();
        else return 0;
    }

    public int getUserJobHistorySize(String userName){
        if(WriterReader.UsersHM.get(userName).getJobsHistory().isEmpty())
            return 0;
        else return WriterReader.UsersHM.get(userName).getJobsHistory().size();
    }

    public  String HistoryDescription(String userName, int i){
        return WriterReader.UsersHM.get(userName).getJobsHistory().get(i).getDescription();
    }

    public  String JobDescription(String userName, int i){
        return WriterReader.UsersHM.get(userName).getJobs().get(i).getDescription();
    }

    public Boolean JobAcceptance(String userName,int i){
        return WriterReader.UsersHM.get(userName).getJobs().get(i).getAccepted();
    }

    public void JobSetAcceptance(String userName,int i){
        WriterReader.UsersHM.get(userName).getJobs().get(i).setAccepted();
    }

    public void setNewJob(String CustomerUserName,String WorkerUserName,String description){
        WriterReader.UsersHM.get(WorkerUserName).addJob(WorkerUserName,CustomerUserName,description);
    }

    //After Fixing saving error of new jobs
    public void acceptJob(String WorkerUserName , String CusUserName){
        ArrayList<Job> list = WriterReader.UsersHM.get(WorkerUserName).getJobs();
        for(Job job : list){
            if(job.getCustomerUserName() == CusUserName){
                job.setAccepted();
                WriterReader.UsersHM.get(CusUserName).getJobs().add(job);
            }
        }
    }

    public  int HistoryID(String userName, int i){
        return WriterReader.UsersHM.get(userName).getJobsHistory().get(i).getId();
    }

    public  int JobID(String userName, int i){
        return WriterReader.UsersHM.get(userName).getJobs().get(i).getId();
    }

    public int getResultsSize(String prof,String area){
        int results=0;
        ArrayList<String> keys = new ArrayList<>(WriterReader.UsersHM.keySet());
        for (String key : keys)
        {
            User user = WriterReader.UsersHM.get(key);
           if(user.getUserType()==UserType.freelancer && (((Freelancer)user).getArea()) != null &&  ((Freelancer)user).getArea().equals(area) && (((Freelancer)user).getField()) != null &&  ((Freelancer)user).getField().equals(prof))
               results++;
           else if(user.getUserType()==UserType.contractor && (((Contractor)user).getArea()) != null &&  ((Contractor)user).getArea().equals(area) && (((Contractor)user).getField()) != null &&  ((Contractor)user).getField().equals(prof))
               results++;
        }
        return results;
    }

    public String getResultsName(String prof,String area,int i) {
        List<User> results = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(WriterReader.UsersHM.keySet());
        for (String key : keys)
        {
            User user = WriterReader.UsersHM.get(key);
            if(user.getUserType()==UserType.freelancer && (((Freelancer)user).getArea()) != null &&  ((Freelancer)user).getArea().equals(area) && (((Freelancer)user).getField()) != null &&  ((Freelancer)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
            else if(user.getUserType()==UserType.contractor && (((Contractor)user).getArea()) != null &&  ((Contractor)user).getArea().equals(area) && (((Contractor)user).getField()) != null &&  ((Contractor)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
        }
        return results.get(i).getFirstName();
    }

    public String getResultsUserName(String prof,String area,int i) {
        List<User> results = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(WriterReader.UsersHM.keySet());
        for (String key : keys)
        {
            User user = WriterReader.UsersHM.get(key);
            if(user.getUserType()==UserType.freelancer &&
                    (((Freelancer)user).getArea()) != null &&
                    ((Freelancer)user).getArea().equals(area) &&
                    (((Freelancer)user).getField()) != null &&
                    ((Freelancer)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
            else if(user.getUserType()==UserType.contractor &&
                    (((Contractor)user).getArea()) != null &&
                    ((Contractor)user).getArea().equals(area) &&
                    (((Contractor)user).getField()) != null &&
                    ((Contractor)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
        }
        return results.get(i/2).getUserName();
    }



    public String getResultsSub(String prof, String area, int i) {
        List<User> results = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(WriterReader.UsersHM.keySet());
        for (String key : keys)
        {
            User user = WriterReader.UsersHM.get(key);
            if(user.getUserType()==UserType.freelancer && (((Freelancer)user).getArea()) != null &&  ((Freelancer)user).getArea().equals(area) && (((Freelancer)user).getField()) != null &&  ((Freelancer)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
            else if(user.getUserType()==UserType.contractor && (((Contractor)user).getArea()) != null &&  ((Contractor)user).getArea().equals(area) && (((Contractor)user).getField()) != null &&  ((Contractor)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
        }
        if(results.get(i).getUserType()==UserType.contractor) {
            return ((Contractor) results.get(i)).getSubfield();
        }
        else if (results.get(i).getUserType()==UserType.freelancer) {
            return ((Freelancer) results.get(i)).getSubfield();
        }
        return null;
    }

  /*  public double getResultsRating(String prof, String area, int i) {
        List<User> results = new ArrayList<>();
        ArrayList<String> keys = new ArrayList<>(WriterReader.UsersHM.keySet());
        for (String key : keys)
        {
            User user = WriterReader.UsersHM.get(key);
            if(user.getUserType()==UserType.freelancer && (((Freelancer)user).getArea()) != null &&  ((Freelancer)user).getArea().equals(area) && (((Freelancer)user).getField()) != null &&  ((Freelancer)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
            else if(user.getUserType()==UserType.contractor && (((Contractor)user).getArea()) != null &&  ((Contractor)user).getArea().equals(area) && (((Contractor)user).getField()) != null &&  ((Contractor)user).getField().equals(prof))
                results.add(WriterReader.UsersHM.get(key));
        }
        if(results.get(i).getRating() == 0)
            return 1;
        else return results.get(i).getRating();
    }*/

}




