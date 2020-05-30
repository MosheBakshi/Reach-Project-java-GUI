package com.reach.view;

import com.reach.controller.MyController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReviewScreen extends JFrame implements View {

    protected static JTextField VerbalReview;
    protected static JTextField Cost;
    protected static JTextField Deadline;
    protected static JTextField Quality;

    public void showScreen(String userName, String workerUserName) {

        setSize(550, 300);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Font
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david10 = new Font("forget a password", Font.PLAIN, 15);

        //Label
        JLabel Verbal = new JLabel("Write a verbal review:");
        Verbal.setBounds(20, 0, 200, 50);
        Verbal.setFont(david20);
        add(Verbal);

        //text field
        ReviewScreen.VerbalReview =new JTextField("");
        VerbalReview.setBounds(250,10,250,30);
        VerbalReview.setFont(david10);
        add(VerbalReview);

        //Label
        JLabel intReview = new JLabel("Review 1-5:");
        intReview.setBounds(20, 50, 200, 50);
        intReview.setFont(david20);
        add(intReview);

        //Label
        JLabel cost = new JLabel("Cost:");
        cost.setBounds(20, 100, 100, 50);
        cost.setFont(david20);
        add(cost);

        //text field
        ReviewScreen.Cost =new JTextField(""); //NEED TO LIMIT TO NUMBERS ONLY!!!
        Cost.setBounds(110,108,100,30);
        Cost.setFont(david10);
        add(Cost);

        //Label
        JLabel deadline = new JLabel("Deadline:");
        deadline.setBounds(20, 150, 100, 50);
        deadline.setFont(david20);
        add(deadline);

        //text field
        ReviewScreen.Deadline =new JTextField(""); //NEED TO LIMIT TO NUMBERS ONLY!!!
        Deadline.setBounds(110,158,100,30);
        Deadline.setFont(david10);
        add(Deadline);

        //Label
        JLabel quality = new JLabel("Quality:");
        quality.setBounds(20, 200, 100, 50);
        quality.setFont(david20);
        add(quality);

        //text field
        ReviewScreen.Quality =new JTextField(""); //NEED TO LIMIT TO NUMBERS ONLY!!!
        Quality.setBounds(110,208,100,30);
        Quality.setFont(david10);
        add(Quality);

        //button
        JButton Confirm = new JButton("Confirm");
        Confirm.setBounds(450, 230, 80, 30); //on clicking pass relevant values and return to main panel
        Confirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String verbal = VerbalReview.toString();
                int id = MyController.getInstance().getUserInfo(MainPanel.getEnterUserName().toString()).getUserId();
                double cost = (double) Integer.getInteger(Cost.toString());
                double deadline = (double) Integer.getInteger(Deadline.toString());
                double quality = (double) Integer.getInteger(Quality.toString());
                MyController.createReview(verbal,id,cost,deadline,quality);
                JOptionPane.showMessageDialog(null, "Review done");
                MainPanel v1 = new MainPanel();
                v1.showScreen();
                //close prev window
            }
        });
        add(Confirm);

        setVisible(true);
    }

    public static void main(String[] args) {
        View v1 = new ReviewScreen();
        v1.showScreen();
    }

    @Override
    public void showScreen() {
    }
}
