package com.reach.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Consumer extends JFrame implements View{

    private static String username;

    public Consumer(String text) {
        username=text;
    }

    public static String getUsername() {
        return username;
    }

    @Override
    public void showScreen() {

        setSize(500, 500);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Font
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david12 = new Font("forget a password", Font.BOLD, 12);


        //label and button
        JLabel contractor = new JLabel("Hello "+username);
        contractor.setBounds(15, 120, 150, 100);
        contractor.setFont(david12);
        add(contractor);
        JButton onGoingJobs = new JButton("On-Going Jobs");
        onGoingJobs.setBounds(345, 60, 125, 15);
        onGoingJobs.setBorderPainted(false);
        onGoingJobs.setFont(david12);
        onGoingJobs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JobListScreen jobList = new JobListScreen();
                jobList.showScreen();
            }
        });
        add(onGoingJobs);
        JButton jobHistory = new JButton("Job History");
        jobHistory.setBounds(345, 100, 125, 15);
        jobHistory.setBorderPainted(false);
        jobHistory.setFont(david12);
        jobHistory.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                JobHistoryListScreen jobList = new JobHistoryListScreen();
                jobList.showScreen();
            }
        });
        add(jobHistory);
        JButton Search = new JButton("Search");
        Search.setBounds(345, 140, 125, 15);
        Search.setBorderPainted(false);
        Search.setFont(david12);
        Search.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
            setVisible(false);
            SearchScreen mainScreenLogIn = new SearchScreen(username);
            mainScreenLogIn.showScreen();
         }
        });
        add(Search);
        JButton personalDetails = new JButton("Personal Details");
        personalDetails.setBounds(15, 185, 150, 15);
        personalDetails.setBorderPainted(false);
        personalDetails.setFont(david12);
        personalDetails.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                PersonalDetails personalDetails = new PersonalDetails(username);
                personalDetails.showScreen();
            }
        });
        add(personalDetails);


        //Bg
        ImageIcon background_image = new ImageIcon("profilePic.png");
        Image img = background_image.getImage();
        Image tmp_img = img.getScaledInstance(500, 500, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(tmp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 500, 500);
        add(background);
        setVisible(true);
    }

    public static void main(String[] args) {
        Consumer v = new Consumer("orel");
        v.showScreen();
    }
}
