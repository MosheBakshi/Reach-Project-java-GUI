package com.reach.view;

import com.reach.controller.MyController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JobScreen extends JFrame implements View {

    protected String userName;
    protected String workerUsername;
    protected JTextField description;
    protected JTextField start;
    protected JTextField end;
    protected JTextField price;

    @Override
    public void showScreen()
    {

        setSize(600, 600);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Font
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david10 = new Font("forget a password", Font.PLAIN, 15);

        JLabel descriptionLabel = new JLabel("Description: ");
        descriptionLabel.setBounds(20, 20, 200, 50);
        descriptionLabel.setFont(david20);
        add(descriptionLabel);

        JLabel description = new JLabel("");
        description.setBounds(40, 20, 200, 50);
        description.setFont(david20);
        add(description);

        JLabel userNameLable = new JLabel("Customer user name: ");
        userNameLable.setBounds(20, 70, 200, 50);
        userNameLable.setFont(david20);
        add(userNameLable);

        JLabel userName = new JLabel("");
        userName.setBounds(40, 70, 200, 50);
        userName.setFont(david20);
        add(userName);

        JLabel workerUserNameLable = new JLabel("Contractor / Freelancer user name: ");
        workerUserNameLable.setBounds(20, 120, 400, 50);
        workerUserNameLable.setFont(david20);
        add(workerUserNameLable);

        JLabel workerUserName = new JLabel("");
        workerUserName.setBounds(40, 120, 200, 50);
        workerUserName.setFont(david20);
        add(workerUserName);

        JLabel startLabel = new JLabel("Start date: ");
        startLabel.setBounds(20, 170, 400, 50);
        startLabel.setFont(david20);
        add(startLabel);

        JLabel start = new JLabel("");
        start.setBounds(40, 170, 200, 50);
        start.setFont(david20);
        add(start);

        JLabel endLabel = new JLabel("End date: ");
        endLabel.setBounds(20, 220, 400, 50);
        endLabel.setFont(david20);
        add(endLabel);

        JLabel end = new JLabel("");
        end.setBounds(40, 220, 200, 50);
        end.setFont(david20);
        add(end);

        JLabel priceLabel = new JLabel("Price: ");
        priceLabel.setBounds(20, 270, 400, 50);
        priceLabel.setFont(david20);
        add(priceLabel);

        JLabel price = new JLabel("");
        price.setBounds(40, 270, 200, 50);
        price.setFont(david20);
        add(price);

        //button
        JButton writeReview = new JButton("Write a review");
        writeReview.setBounds(380, 500, 150, 30); //on clicking pass relevant values and return to main panel
        writeReview.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyController.getInstance().writeReview(JobScreen.this.userName, workerUsername);
                //close prev window
            }
        });
        add(writeReview);

        setVisible(true);
    }

    public static void main(String[] args) {
        View v1 = new JobScreen();
        v1.showScreen();
    }

}
