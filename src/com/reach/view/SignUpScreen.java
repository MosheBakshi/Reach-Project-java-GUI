package com.reach.view;

import com.reach.controller.ButtonListener;
import com.reach.controller.MyController;
import com.reach.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpScreen extends JFrame implements View {
    protected static JTextField enterUserName;
    protected static JTextField enterPrivateName;
    protected static JTextField enterLastName;
    protected static JPasswordField enterPassword;
    protected static JPasswordField enterConfirmedPassword;
    protected static ButtonModel selection;
    protected static ButtonGroup group;

    public static JTextField getUsername(){
        return enterUserName;
    }

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

        JLabel create_reach_account = new JLabel("Create REACH account");
        create_reach_account.setBounds(15, 10, 450, 100);
        create_reach_account.setFont(david30);
        add(create_reach_account);
        // for JLabel - not the var of the string
        JLabel firstName = new JLabel("First Name");
        firstName.setBounds(15, 100, 100, 100);
        firstName.setFont(david15);
        add(firstName);
        // for JTextField - var to pass into controller
        enterPrivateName = new JTextField("");
        enterPrivateName.setBounds(108, 145, 150, 20);
        add(enterPrivateName);
        // for Jlabel - not var of the string
        JLabel lastName = new JLabel("Last Name");
        lastName.setBounds(308, 100, 100, 100);
        lastName.setFont(david15);
        add(lastName);
        // for JTextField - var to pass into controller
        enterLastName = new JTextField("");
        enterLastName.setBounds(385, 145, 150, 20);
        add(enterLastName);

        // for Jlabel - not var to pass
        JLabel userName = new JLabel("User Name");
        userName.setBounds(15, 140, 100, 100);
        userName.setFont(david15);
        add(userName);

        // for JTextField - var to pass into controller
        enterUserName = new JTextField("");
        enterUserName.setBounds(108, 181, 150, 20);
        add(enterUserName);

        // for Jlabel - not var to pass
        JLabel password = new JLabel("Password");
        password.setBounds(15, 174, 100, 100);
        password.setFont(david15);
        add(password);
        // for JTextField - var to pass into controller
        enterPassword = new JPasswordField("");
        enterPassword.setBounds(108, 215, 150, 20);
        add(enterPassword);
        // for Jlabel - not var to pass
        JLabel confirmedPassword = new JLabel("Confirm Password");
        confirmedPassword.setBounds(260, 174, 130, 100);
        confirmedPassword.setFont(david15);
        add(confirmedPassword);
        // for JTextField - var to pass into controller
        enterConfirmedPassword = new JPasswordField("");
        enterConfirmedPassword.setBounds(385, 215, 150, 20);
        add(enterConfirmedPassword);
        // for Jlabel - not var to pass
        JLabel useLettersNumbers = new JLabel("Use with letters and numbers");
        useLettersNumbers.setBounds(105, 190, 200, 100);
        useLettersNumbers.setFont(david12);
        add(useLettersNumbers);
        //
        JButton done = new JButton("Done");
        done.setBounds(635, 670, 100, 30);
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                MyController.getInstance().createUser(getSelection(), enterUserName.getText());
                JOptionPane.showMessageDialog(null, "Sign up successfully");
                MainPanel v1 = new MainPanel();
                v1.showScreen();
            }
        });
        add(done);

        // create radio buttons and labels
        JLabel tChoice = new JLabel("User type define:");
        tChoice.setBounds(15,250,450,100 );
        tChoice.setFont(david30);

        JRadioButton consumer = new JRadioButton("Consumer");
        consumer.setActionCommand("Consumer");
        consumer.setBackground(Color.white);
        consumer.setBounds(270,340 ,100 ,20 );
        consumer.setSelected(true);

        JRadioButton freelancer = new JRadioButton("Freelancer");
        freelancer.setActionCommand("Freelancer");
        freelancer.setBackground(Color.white);
        freelancer.setBounds(270,370,100,20 );

        JRadioButton contractor = new JRadioButton("Contractor");
        contractor.setActionCommand("Contractor");
        contractor.setBackground(Color.white);
        contractor.setBounds(270,400,100,20 );

        // create radio group
        group = new ButtonGroup();
        group.add(consumer);
        group.add(freelancer);
        group.add(contractor);
        add(consumer);
        add(freelancer);
        add(contractor);
        add(tChoice);
        selection = group.getSelection();

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

    public String getSelection() {
        return group.getSelection().getActionCommand();
    }
}
