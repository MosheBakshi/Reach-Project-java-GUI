package com.reach.view;

import com.reach.controller.MyController;
import com.reach.model.UserType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobHistoryListScreen extends JFrame implements View
{
    protected static String userName;
    protected UserType userType;
    public JobHistoryListScreen(String userName){
        this.userName = userName;
    }
    @Override
    public void showScreen()
    {
        setSize(1000, 1000);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main,BoxLayout.PAGE_AXIS));
        main.setBounds(0,0,1000,1000);
        add(main);

        //Font
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david50 = new Font("David", Font.BOLD, 50);
        userType = MyController.getInstance().getUserType(userName);
        try{
            if(userType == UserType.customer){throw new Exception("customer");}
            else if(userType == UserType.freelancer){ throw new Exception("freelancer");}
            else if (userType == UserType.contractor){throw new Exception("contractor");}
        }
        catch (Exception exc){
            if(exc.getMessage() == "customer"){
                if (MyController.getInstance().getUserJobHistorySize(Consumer.getUsername())>0)
                {
                    int x = MyController.getInstance().getUserJobHistorySize(Consumer.getUsername());
                    for(int i=0;i<x;i++)
                    {
                        String desc = MyController.getInstance().HistoryDescription(Consumer.getUsername(),x);
                        JLabel jobDescription = new JLabel("Description: " + desc);
                        jobDescription.setBounds(20, i * 50 + 100, 400, 30);
                        jobDescription.setFont(david20);
                        main.add(jobDescription);

                        int ID = MyController.getInstance().HistoryID(Consumer.getUsername(),x);
                        JLabel jobID = new JLabel("Job id: " + ID);
                        jobID.setBounds(20, i * 50 + 150, 200, 30);
                        jobID.setFont(david20);
                        main.add(jobID);

                        JButton goTo = new JButton("See job details");
                        goTo.setBounds(350, i * 50 + 150, 200, 30);
                        goTo.setFont(david20);
                        main.add(goTo);
                    }
                }
                else
                {
                    JLabel empty = new JLabel("No jobs to display!");
                    empty.setBounds(500, 500, 100, 100);
                    empty.setFont(david50);
                    main.add(empty);
                }
            }
            else if(exc.getMessage() == "freelancer"){
                if (MyController.getInstance().getUserJobHistorySize(Freelancer.getUsername())>0)
                {
                    int x = MyController.getInstance().getUserJobHistorySize(Freelancer.getUsername());
                    for(int i=0;i<x;i++)
                    {
                        String desc = MyController.getInstance().HistoryDescription(Freelancer.getUsername(),x);
                        JLabel jobDescription = new JLabel("Description: " + desc);
                        jobDescription.setBounds(20, i * 50 + 100, 400, 30);
                        jobDescription.setFont(david20);
                        main.add(jobDescription);

                        int ID = MyController.getInstance().HistoryID(Freelancer.getUsername(),x);
                        JLabel jobID = new JLabel("Job id: " + ID);
                        jobID.setBounds(20, i * 50 + 150, 200, 30);
                        jobID.setFont(david20);
                        main.add(jobID);

                        JButton goTo = new JButton("See job details");
                        goTo.setBounds(350, i * 50 + 150, 200, 30);
                        goTo.setFont(david20);
                        main.add(goTo);
                    }
                }
                else
                {
                    JLabel empty = new JLabel("No jobs to display!");
                    empty.setBounds(500, 500, 100, 100);
                    empty.setFont(david50);
                    main.add(empty);
                }
            }
            else if(exc.getMessage() == "contractor"){
                if (MyController.getInstance().getUserJobHistorySize(Contractor.getUsername())>0)
                {
                    int x = MyController.getInstance().getUserJobHistorySize(Contractor.getUsername());
                    for(int i=0;i<x;i++)
                    {
                        String desc = MyController.getInstance().HistoryDescription(Contractor.getUsername(),x);
                        JLabel jobDescription = new JLabel("Description: " + desc);
                        jobDescription.setBounds(20, i * 50 + 100, 400, 30);
                        jobDescription.setFont(david20);
                        main.add(jobDescription);

                        int ID = MyController.getInstance().HistoryID(Contractor.getUsername(),x);
                        JLabel jobID = new JLabel("Job id: " + ID);
                        jobID.setBounds(20, i * 50 + 150, 200, 30);
                        jobID.setFont(david20);
                        main.add(jobID);

                        JButton goTo = new JButton("See job details");
                        goTo.setBounds(350, i * 50 + 150, 200, 30);
                        goTo.setFont(david20);
                        main.add(goTo);
                    }
                }
                else
                {
                    JLabel empty = new JLabel("No jobs to display!");
                    empty.setBounds(500, 500, 100, 100);
                    empty.setFont(david50);
                    main.add(empty);
                }
            }
        }

        JButton home = new JButton("Home");
        home.setBounds(0, 670, 100, 30);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UserType userTypeReturned = MyController.getInstance().getUserType(userName);
                    if(userTypeReturned == UserType.customer){throw new Exception("consumer");}
                    else if(userTypeReturned == UserType.freelancer){throw new Exception("freelancer");}
                    else if(userTypeReturned == UserType.contractor){throw new Exception("contractor");}
                }
                catch (Exception exc){
                    if(exc.getMessage() == "consumer"){
                        setVisible(false);
                        Consumer v1 = new Consumer(userName);
                        v1.showScreen();
                    }
                    else if(exc.getMessage() == "freelancer"){
                        setVisible(false);
                        Freelancer v1 = new Freelancer(userName);
                        v1.showScreen();
                    }
                    else if(exc.getMessage() == "contractor"){
                        setVisible(false);
                        Contractor v1 = new Contractor(userName);
                        v1.showScreen();
                    }
                }
            }
        });
        add(home);
        JScrollPane scroll = new JScrollPane(main,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0,0,980,1000);
        add(scroll);
        setVisible(true);
    }
}