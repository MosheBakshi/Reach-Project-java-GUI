package com.reach.view;

import com.reach.controller.ButtonListener;
import com.reach.controller.MyController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.invoke.StringConcatException;


public class MainPanel extends JFrame implements View {

    private static JTextField enterUserName;
    private static JPasswordField enterPassword;
    private JButton logIn;
    private JButton signUp;
    private JButton forgetPassword;

    public static JTextField getEnterUserName() {
        return enterUserName;
    }

    public static JPasswordField getEnterPassword() {
        return enterPassword;
    }


    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        else
            return false;
    }


    @Override
    public void showScreen() {
        //The Frame
        setSize(700, 600);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Font
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david10 = new Font("forget a password", Font.PLAIN, 10);

        //Labels and Buttons
        JLabel userName = new JLabel("user name");
        userName.setBounds(15, 200, 100, 100);
        userName.setFont(david20);
        add(userName);
        enterUserName = new JTextField("");
        enterUserName.setBounds(108, 241, 150, 20);
        add(enterUserName);
        // go t
        JLabel password = new JLabel("password");
        password.setBounds(15, 220, 100, 100);
        password.setFont(david20);
        add(password);
        forgetPassword = new JButton("Forgot password");
        forgetPassword.setBounds(140, 315, 150, 15);
        forgetPassword.setBackground(Color.white);
        forgetPassword.setBorderPainted(false);
        forgetPassword.setFont(david10);
        forgetPassword.addActionListener(new ButtonListener(this));
        forgetPassword.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 setVisible(false);
                 JOptionPane.showMessageDialog(null, "Set email adress:");
                 MainPanel v1 = new MainPanel();
                 v1.showScreen();
             }

         });
        add(forgetPassword);
        enterPassword = new JPasswordField("");
        enterPassword.setBounds(108, 261, 150, 20);
        add(enterPassword);
        JLabel notAMember = new JLabel("Not a member?");
        notAMember.setBounds(15, 350, 200, 100);
        notAMember.setFont(david20);
        add(notAMember);
        signUp = new JButton("Sign Up Here");
        signUp.setBounds(150, 384, 110, 30);
        signUp.addActionListener(new ButtonListener(this));
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                   setVisible(false);
                   SignUpScreen signUpScreen = new SignUpScreen();
                   signUpScreen.showScreen();
            }
            });
        add(signUp);
        logIn = new JButton("Log In");
        logIn.setBounds(157, 281, 100, 30);
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name;
                try {
                    if (enterUserName.getText().equals("") || enterPassword.getText().equals("")) {
                        throw new MyException("One field is empty");
                    }//checking for the user name write the right password
                    else if( MyController.getInstance().verifyUserNameAndPassword(enterUserName.getText(),new String(enterPassword.getPassword()))){
                        setVisible(false);
                        JOptionPane.showMessageDialog(null, "Log in successful");
                        MainScreenLogIn mainScreenLogIn = new MainScreenLogIn(enterUserName.getText());
                        mainScreenLogIn.showScreen();
                    }
                    else{//wrong password
                        throw new MyException("The user or password are wrong");
                    }
                } catch (MyException exc) {
                    exc.print();
                }
            }
        });
        add(logIn);


        //Bg
        ImageIcon background_image = new ImageIcon("BgImg1.png");
        Image img = background_image.getImage();
        Image tmp_img = img.getScaledInstance(700, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(tmp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 700, 600);
        add(background);


        setVisible(true);


    }

}




