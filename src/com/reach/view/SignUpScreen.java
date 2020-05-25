package com.reach.view;

import com.reach.controller.ButtonListener;
import com.reach.controller.MyController;
import com.reach.model.User;

import javax.swing.*;
import java.awt.*;

public class SignUpScreen extends JFrame implements View {
    protected String selection;
    protected String uname;
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
        // for JLabel - not the var of the string
        JLabel firstName = new JLabel("First Name");
        firstName.setBounds(15, 150, 100, 100);
        firstName.setFont(david15);
        add(firstName);
        // for JTextField - var to pass into controller
        JTextField enterPrivateName = new JTextField("");
        enterPrivateName.setBounds(108, 191, 150, 20);
        add(enterPrivateName);
        // for Jlabel - not var of the string
        JLabel lastName = new JLabel("Last Name");
        lastName.setBounds(308, 150, 100, 100);
        lastName.setFont(david15);
        add(lastName);
        // for JTextField - var to pass into controller
        JTextField enterLastName = new JTextField("");
        enterLastName.setBounds(385, 191, 150, 20);
        add(enterLastName);

        // for Jlabel - not var to pass
        JLabel userName = new JLabel("User Name");
        userName.setBounds(15, 179, 100, 100);
        userName.setFont(david15);
        add(userName);

        // for JTextField - var to pass into controller
        JTextField enterUserName = new JTextField("");
        enterUserName.setBounds(108, 220, 150, 20);
        add(enterUserName);
        uname = enterUserName.getText();
        JOptionPane.showMessageDialog(null, uname);


        // for Jlabel - not var to pass
        JLabel password = new JLabel("Password");
        password.setBounds(15, 210, 100, 100);
        password.setFont(david15);
        add(password);
        // for JTextField - var to pass into controller
        JPasswordField enterPassword = new JPasswordField("");
        enterPassword.setBounds(95, 251, 150, 20);
        add(enterPassword);
        // for Jlabel - not var to pass
        JLabel confirmedPassword = new JLabel("Confirm Password");
        confirmedPassword.setBounds(260, 210, 130, 100);
        confirmedPassword.setFont(david15);
        add(confirmedPassword);
        // for JTextField - var to pass into controller
        JPasswordField enterConfirmedPassword = new JPasswordField("");
        enterConfirmedPassword.setBounds(385, 251, 150, 20);
        add(enterConfirmedPassword);
        // for Jlabel - not var to pass
        JLabel useLettersNumbers = new JLabel("Use with letters and numbers");
        useLettersNumbers.setBounds(90, 230, 200, 100);
        useLettersNumbers.setFont(david12);
        add(useLettersNumbers);
        //
        JButton done = new JButton("Done");
        done.setBounds(400, 350, 100, 30);
        done.addActionListener(new ButtonListener(this));
        add(done);


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
    public String getUname(){
        return uname;
    }
}
