package com.reach.controller;

import com.reach.view.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {
    View currentView;
    MyController forModel;
    protected static String usname = " ";
    protected static String choice = "Customer";
    private Window mainScreen;

    //Constructors
    public ButtonListener(MainPanel mainPanel) {
        this.mainScreen = mainPanel;
    }

    public ButtonListener(MainScreenLogIn mainScreenLogIn) {
        this.mainScreen = mainScreenLogIn;
    }

    public ButtonListener(SignUpScreen signUpScreen) {
        this.mainScreen = signUpScreen;
    }

    public void ButtonListener(Window mainScreen) {
        this.mainScreen = mainScreen;
    }

    //equals the button to the name
    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        else
            return false;
    }

    public void actionPerformed(ActionEvent actionEvent) {
        String name;

        name = actionEvent.getActionCommand();
        if (name.equals("Log In")) {
            JTextField userName = MainPanel.getEnterUserName();
            JPasswordField Password = MainPanel.getEnterPassword();
            try {
                if (userName.getText().equals("")) {
                    throw new Exception("err");
                }
                JOptionPane.showMessageDialog(null, "Log in successful");
                System.out.println(userName.getText());
                System.out.println(Password.getPassword());
                mainScreen.setVisible(false);

                //פונקציה שמחזירה האם השם משתמש והסיסמא הם פרילנסר קליינט או בעל מקצוע
                //Here -> Controller -> Model
                //Model -> controller -> view


                MainScreenLogIn mainScreenLogIn = new MainScreenLogIn(userName.getText());
                mainScreenLogIn.showScreen();
            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "Error Username or Password");
            }
        }
        if (name.equals("Sign Up Here")) {
            mainScreen.setVisible(false);
            SignUpScreen signUpScreen = new SignUpScreen();
            signUpScreen.showScreen();
            choice = signUpScreen.getSelection();
            usname = signUpScreen.getUsername().getText();
        }

        if (name.equals("Forgot password")) {
            mainScreen.setVisible(false);
            JOptionPane.showMessageDialog(null, "Set email adress:");
            MainPanel v1 = new MainPanel();
            v1.showScreen();
        }
        if (name.equalsIgnoreCase("Done")) {
            mainScreen.setVisible(false);
            forModel = new MyController(choice, usname);
            JOptionPane.showMessageDialog(null, "Sign up successfully");
            //Contorller -> Model
            MainPanel v1 = new MainPanel();
            v1.showScreen();
          //  mainScreen.dispatchEvent(new WindowEvent(mainScreen, WindowEvent.WINDOW_CLOSING));

        }
        if (name.equalsIgnoreCase("search")) {
            try {
                String choosePro = MainScreenLogIn.getProfessional();
                String chooseArea = MainScreenLogIn.getAreaBox();
                if ((choosePro.equals("Professional")) || (chooseArea.equals("Area"))) {
                    throw new Exception("err");
                }
                mainScreen.setVisible(false);
                getChooseCustomer(choosePro, chooseArea);
                /*
                    add from controller to model
                    and the return way

                 */

                SearchResult screenSearchResult = new SearchResult();
                screenSearchResult.showScreen();

            } catch (Exception exc) {
                JOptionPane.showMessageDialog(null, "You have to choose area and professional");
            }
        }
    }

    private void getChooseCustomer(String choosePro, String chooseArea) {
        System.out.println(choosePro);
        System.out.println(chooseArea);
    }
}
