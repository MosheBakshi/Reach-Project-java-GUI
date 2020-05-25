/*
package com.reach.view;
import com.reach.controller.MyController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;


public class ButtonListener implements ActionListener {

    private Window mainScreen;

    public ButtonListener(Window mainScreen) {
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
        //View logIn = new View();
        if (name.equals("Log In")) {
            JTextField userName = MainPanel.getEnterUserName();
            JPasswordField Password = MainPanel.getEnterPassword();
            try{
                if(userName.getText().equals("")){
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
            }
            catch(Exception exc){
                JOptionPane.showMessageDialog(null, "Error");
            }
        }
        if (name.equals("Sign Up Here")) {
            mainScreen.setVisible(false);
            SignUpScreen signUpScreen = new SignUpScreen();
            signUpScreen.showScreen();

        }
        if (name.equals("forget a password")) {
            mainScreen.setVisible(false);
            JOptionPane.showMessageDialog(null, "hsdfsfsdfello");

        }
        if (name.equalsIgnoreCase("Next")){
            mainScreen.setVisible(false);
            JOptionPane.showMessageDialog(null, "Sign up successfully");
            //Contorller -> Model
            mainScreen.dispatchEvent(new WindowEvent(mainScreen, WindowEvent.WINDOW_CLOSING));

        }
        if (name.equalsIgnoreCase("search")){
            try{
                String  choosePro = MainScreenLogIn.getProfessional();
                String chooseArea = MainScreenLogIn.getAreaBox();
                if((choosePro.equals("Professional")) || (chooseArea.equals("Area"))){
                    throw new Exception("err");
                }
                mainScreen.setVisible(false);
                MyController.getChooseCustomer(choosePro,chooseArea);
                /*
                    add from controller to model
                    and the return way

                 */
/*
                SearchResult screenSearchResult = new SearchResult();
                screenSearchResult.showScreen();

            }
            catch(Exception exc){
                JOptionPane.showMessageDialog(null, "You have to choose area and professional");
            }
        }
    }



}
*/