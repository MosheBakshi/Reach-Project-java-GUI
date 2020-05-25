package com.reach.view;

import com.reach.controller.ButtonListener;
import com.reach.controller.MyController;

import javax.swing.*;
import java.awt.*;

public class ChooseDefineScreen extends JFrame implements View {
    protected String choice;
    protected static ButtonModel selection;
 @Override
 public void showScreen() {
     setSize(750, 750);
     setLayout(null);
     setDefaultCloseOperation(EXIT_ON_CLOSE);

     //Font
     Font david30 = new Font("David", Font.BOLD, 30);


    // create radio buttons and labels
     JLabel tChoice = new JLabel("User type define:");
     tChoice.setBounds(150,150,350,50 );
     tChoice.setFont(david30);

     JRadioButton consumer = new JRadioButton("Consumer");
     consumer.setActionCommand("Consumer");
     consumer.setBounds(400,230 ,100 ,20 );
     consumer.setSelected(true);

     JRadioButton freelancer = new JRadioButton("Freelancer");
     freelancer.setActionCommand("Freelancer");
     freelancer.setBounds(400,250,150,20 );

     JRadioButton contractor = new JRadioButton("Contractor");
     contractor.setActionCommand("Contractor");
     contractor.setBounds(400,270,200,20 );

     // create radio group

     ButtonGroup group = new ButtonGroup();
     group.add(consumer);
     group.add(freelancer);
     group.add(contractor);


     add(consumer);
     add(freelancer);
     add(contractor);
     add(tChoice);


     selection = group.getSelection();
     choice = selection.getActionCommand();

     JButton next = new JButton("Next");
     next.setBounds(600, 600, 100, 30);
     next.addActionListener(new ButtonListener(this));
     add(next);

     setVisible(true);
 }

    public String getChoice() {
        return choice;
    }


}

