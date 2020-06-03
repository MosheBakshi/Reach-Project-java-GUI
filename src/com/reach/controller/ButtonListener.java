package com.reach.controller;

import com.reach.view.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonListener implements ActionListener {

    private Window mainScreen;


    //Constructors
    public ButtonListener(MainPanel mainPanel) {
        this.mainScreen = mainPanel;
    }

    public ButtonListener(SearchScreen mainScreenLogIn) {
        this.mainScreen = mainScreenLogIn;
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

        if (name.equalsIgnoreCase("search")) {
            try {
                String choosePro = SearchScreen.getProfession();
                String chooseArea = SearchScreen.getAreaBox();
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
