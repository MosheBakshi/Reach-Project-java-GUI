package com.reach.view;

import com.reach.controller.MyController;
import com.reach.model.UserType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchResult extends JFrame implements  View {
    String userName;
    String prof = SearchScreen.getProfession();
    String area = SearchScreen.getAreaBox();
    public SearchResult(String un){
        userName = un;
    }
    @Override
    public void showScreen() {

        setSize(1000, 1000);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main,BoxLayout.PAGE_AXIS));
        main.setBounds(0,0,900,900);
        add(main);

        //Font
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david50 = new Font("forget a password", Font.PLAIN, 50);

        if (MyController.getInstance().getResultsSize(prof,area)>0)
        {
            int x = MyController.getInstance().getResultsSize(prof,area);
            for (int i = 0; i < x; i++)
            {
                String Name = MyController.getInstance().getResultsName(prof,area,i);
                JLabel name = new JLabel("Name: " + Name);
                name.setFont(david20);
                name.setBounds(20, i * 50 + 100, 200, 30);
                main.add(name);

                String Sub = MyController.getInstance().getResultsSub(prof,area,i);
                JLabel subField = new JLabel("Sub-field: " + Sub);
                subField.setBounds(20, i * 50 + 150, 200, 30);
                subField.setFont(david20);
                main.add(subField);

               /* double rate = MyController.getInstance().getResultsRating(prof,area,i);
                JLabel rating = new JLabel("Rating: " + rate);
                rating.setBounds(20, i * 50 + 200, 200, 30);
                rating.setFont(david20);
                main.add(rating);*/

                JButton go = new JButton("Pick");
                go.setFont(david20);
                go.setBounds(400, i * 50 + 200, 200, 30);
                go.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                    }
                });
                main.add(go);
            }
        }
        else
            {
            JLabel empty = new JLabel("No matching results found");
            empty.setBounds(250, 250, 100, 100);
            empty.setFont(david50);
            main.add(empty);
        }
        JScrollPane scroll = new JScrollPane(main,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0,0,880,900);
        add(scroll);


        JButton home = new JButton("Home");
        home.setBounds(0, 900, 100, 30);
        home.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    UserType userTypeReturned = MyController.getInstance().getUserType(userName);
                    if(userTypeReturned == UserType.customer){throw new Exception("consumer");}
                    else if(userTypeReturned == UserType.freelancer){throw new Exception("freelancer");}
                    else if(userTypeReturned == UserType.contractor){throw new Exception("contractor");}
                }
                catch (Exception exc){
                    if(exc.getMessage() == "consumer"){
                        setVisible(false);
                        Consumer v1 = new Consumer(userName);
                        v1.showScreen();
                    }
                    else if(exc.getMessage() == "freelancer"){
                        setVisible(false);
                        Freelancer v1 = new Freelancer(userName);
                        v1.showScreen();
                    }
                    else if(exc.getMessage() == "contractor"){
                        setVisible(false);
                        Contractor v1 = new Contractor(userName);
                        v1.showScreen();
                    }
                }
            }
        });
        add(home);

        setVisible(true);
    }
}


