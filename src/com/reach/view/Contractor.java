package com.reach.view;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Contractor extends JFrame implements View{

    @Override
    public void showScreen() {

        setSize(700, 600);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Font
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david10 = new Font("forget a password", Font.PLAIN, 10);


        //stam
        JLabel contractor = new JLabel("contractor");
        contractor.setBounds(15, 220, 100, 100);
        contractor.setFont(david20);
        add(contractor);

        setVisible(true);
    }

}
