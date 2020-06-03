package com.reach.view;

import com.reach.controller.MyController;
import com.reach.model.Job;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class JobHistoryListScreen extends JFrame implements View
{

    @Override
    public void showScreen()
    {
        ArrayList<Job> jobList = MyController.getInstance().getUserJobHistory(MainPanel.getEnterUserName().toString());
        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Font
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david50 = new Font("David", Font.BOLD, 50);

        if (jobList != null)
        {
            for (int i = 0; i < jobList.size(); i++) {
                JLabel jobDescription = new JLabel("Description: " + jobList.get(i).getDescription());
                jobDescription.setBounds(20, i * 50 + 100, 400, 30);
                jobDescription.setFont(david20);
                add(jobDescription);

                JLabel jobID = new JLabel("Job id: " + jobList.get(i).getId());
                jobID.setBounds(20, i * 50 + 150, 200, 30);
                jobID.setFont(david20);
                add(jobID);

                JButton goTo = new JButton("See job details");
                goTo.setBounds(350, i * 50 + 150, 200, 30);
                goTo.setFont(david20);
                add(goTo);
            }
        }
        else
        {
            JLabel empty = new JLabel("No jobs to display!");
            empty.setBounds(250, 250, 100, 100);
            empty.setFont(david50);
            add(empty);
        }
        setVisible(true);
    }

}