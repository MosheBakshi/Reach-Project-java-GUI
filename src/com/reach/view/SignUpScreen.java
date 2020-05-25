package com.reach.view;

import com.reach.controller.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class SignUpScreen extends JFrame implements View {

    @Override
    public void showScreen() {
        setSize(750, 750);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        //Font
        Font david30 = new Font("David", Font.BOLD, 30);
        Font david15 = new Font("forget a password", Font.PLAIN, 15);
        Font david12 = new Font("forget a password",Font.ITALIC,12);
        Font david25 = new Font("David", Font.BOLD, 25);

        //Label ang Buttons
        JLabel reach = new JLabel("REACH");
        reach.setBounds(15, 15, 250, 100);
        reach.setFont(david25);
        add(reach);
        JLabel create_reach_account = new JLabel("Create REACH account");
        create_reach_account.setBounds(15, 60, 450, 100);
        create_reach_account.setFont(david30);
        add(create_reach_account);
        JLabel firstName = new JLabel("First Name");
        firstName.setBounds(15, 150, 100, 100);
        firstName.setFont(david15);
        add(firstName);
        JTextField enterPrivateName = new JTextField("");
        enterPrivateName.setBounds(108, 191, 150, 20);
        add(enterPrivateName);
        JLabel lastName = new JLabel("Last Name");
        lastName.setBounds(308, 150, 100, 100);
        lastName.setFont(david15);
        add(lastName);
        JTextField enterLastName = new JTextField("");
        enterLastName.setBounds(385, 191, 150, 20);
        add(enterLastName);
        JLabel userName = new JLabel("User Name");
        userName.setBounds(15, 179, 100, 100);
        userName.setFont(david15);
        add(userName);
        JTextField enterUserName = new JTextField("");
        enterUserName.setBounds(108, 220, 150, 20);
        add(enterUserName);
        JLabel password = new JLabel("Password");
        password.setBounds(15, 210, 100, 100);
        password.setFont(david15);
        add(password);
        JPasswordField enterPassword = new JPasswordField("");
        enterPassword.setBounds(95, 251, 150, 20);
        add(enterPassword);
        JLabel confirmedPassword = new JLabel("Confirm Password");
        confirmedPassword.setBounds(260, 210, 130, 100);
        confirmedPassword.setFont(david15);
        add(confirmedPassword);
        JPasswordField enterConfirmedPassword = new JPasswordField("");
        enterConfirmedPassword.setBounds(385, 251, 150, 20);
        add(enterConfirmedPassword);
        JLabel useLettersNumbers = new JLabel("Use with letters and numbers");
        useLettersNumbers.setBounds(90, 230, 200, 100);
        useLettersNumbers.setFont(david12);
        add(useLettersNumbers);
        JButton next = new JButton("NEXT");
        next.setBounds(400, 350, 100, 30);
        next.addActionListener(new ButtonListener(this));
        add(next);
        JLabel consumerL = new JLabel("Consumer");
        consumerL.setBounds(20, 260, 250, 100);
        consumerL.setFont(david12);
        add(consumerL);
        JCheckBox consumer = new JCheckBox();
        consumer.setBounds(40,325,20,20);
        add(consumer);
        JLabel freelancerL = new JLabel("Freelancer");
        freelancerL.setBounds(140, 260, 250, 100);
        freelancerL.setFont(david12);
        add(freelancerL);
        JCheckBox freelancer = new JCheckBox();
        freelancer.setBounds(160,325,20,20);
        add(freelancer);
        JLabel contractorL = new JLabel("Contractor");
        contractorL.setBounds(260, 260, 250, 100);
        contractorL.setFont(david12);
        add(contractorL);
        JCheckBox contractor = new JCheckBox();
        contractor.setBounds(275,325,20,20);
        add(contractor);

        //Bg
        ImageIcon background_image = new ImageIcon("securityBg1.png");
        Image img = background_image.getImage();
        Image tmp_img = img.getScaledInstance(750, 750, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(tmp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 750, 700);
        add(background);

        setVisible(true);
    }

    public static void main(String[] args) {
        SignUpScreen s = new SignUpScreen();
                s.showScreen();
    }
}
