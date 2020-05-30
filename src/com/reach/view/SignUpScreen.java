package com.reach.view;

import com.reach.controller.ButtonListener;
import com.reach.controller.MyController;
import com.reach.controller.SignUpController;
import com.reach.model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Arrays;

public class SignUpScreen extends JFrame implements View {
    protected static JTextField enterUserName;
    protected static JTextField enterPrivateName;
    protected static JTextField enterLastName;
    protected static JPasswordField enterPassword;
    protected static JPasswordField enterConfirmedPassword;
    protected static ButtonModel selection;
    protected static ButtonGroup group;
    protected static JLabel WrongPassword;
    protected static JLabel GoodPassword;
    protected static String input = "";
    protected static String  FirstInput = "";
    protected static boolean DoneFlag = false;
    public static JTextField getUsername(){
        return enterUserName;
    }

    public void setDoneFlag(){
        DoneFlag = !DoneFlag;
    }
    public boolean getDoneFlag(){
        return DoneFlag;
    }

    @Override
    public void showScreen() {

        setSize(750, 750);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel jPan = new JPanel();
        jPan.setBounds(410, 240, 200, 50);
        jPan.setBackground(Color.white);
        add(jPan);
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

        enterConfirmedPassword.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                FirstInput = new String(enterPassword.getPassword()); // for comparing passwords
            }

            @Override
            public void focusLost(FocusEvent e) {
                input = new String(enterConfirmedPassword.getPassword()); // for comparing passwords
                System.out.println(input);
                System.out.println(FirstInput);
                try {
                    if (!(FirstInput.equals(input)) && !(FirstInput.equalsIgnoreCase(""))) {
                        System.out.println("not match throwing exception");
                        throw new Exception("Bad password");
                    } else if (FirstInput.equals(input) && !(FirstInput.equalsIgnoreCase(""))) {
                        System.out.println("match throwing exception");
                        throw new Exception("Passwords match");
                    }
                }
                catch (Exception exc)
                {
                    if(exc.getMessage().equalsIgnoreCase("Bad password")){
                        System.out.println("creating 'bad password' label");
                        jPan.removeAll();
                        jPan.add(WrongPassword);
                        jPan.setVisible(true);
                        jPan.repaint();
                        jPan.revalidate();
                    }
                    if(exc.getMessage().equalsIgnoreCase("Passwords match")){
                        System.out.println("creating 'passwords match' label");
                        jPan.removeAll();
                        jPan.add(GoodPassword);
                        jPan.setVisible(true);
                        jPan.repaint();
                        jPan.revalidate();
                    }
                }
            }
        });
        add(enterConfirmedPassword);

        // for Jlabel - not var to pass
        JLabel useLettersNumbers = new JLabel("Use with letters and numbers");
        useLettersNumbers.setBounds(105, 190, 200, 100);
        useLettersNumbers.setFont(david12);
        add(useLettersNumbers);

        WrongPassword = new JLabel("Bad password");
        WrongPassword.setBounds(410, 240, 200, 15);
        WrongPassword.setFont(david15);
        WrongPassword.setForeground(Color.red);

        GoodPassword = new JLabel("Passwords match");
        GoodPassword.setBounds(410, 240, 200, 15);
        GoodPassword.setFont(david15);
        GoodPassword.setForeground(Color.green);
        //-----------------------------------------------------------------------------------------//
        JButton done = new JButton("Done");
        done.setBounds(635, 670, 100, 30);//on clicking pass relevent values and return to main panel
        done.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                SignUpController.getInstance().createUser(getSelection(), enterUserName.getText(),
                        enterPrivateName.getText(), enterLastName.getText(),
                        FirstInput);
                //setDoneFlag();
                JOptionPane.showMessageDialog(null, "Sign up successfully");
                MainPanel v1 = new MainPanel();
                v1.showScreen();

            }
        });
        add(done);
//-----------------------------------------------------------------------------------------------------//
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
