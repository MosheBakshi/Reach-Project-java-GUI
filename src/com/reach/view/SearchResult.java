package com.reach.view;

import com.reach.controller.MyController;
import com.reach.model.Contractor;
import com.reach.model.User;
import com.reach.model.WriterReader;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class SearchResult extends JFrame implements  View {

    String prof = SearchScreen.getProfession();
    String area = SearchScreen.getAreaBox();
    List<User> results = MyController.getInstance().getResults(prof,area);

    @Override
    public void showScreen() {

        setSize(700, 600);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Font
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david50 = new Font("forget a password", Font.PLAIN, 50);

        if (!results.isEmpty())
        {
            for (int i = 0; i < results.size(); i++)
            {
                JLabel name = new JLabel("Name: " + results.get(i).getFirstName());
                name.setFont(david20);
                name.setBounds(20, i * 50 + 100, 200, 30);
                add(name);

                JLabel subField = new JLabel("Sub-field: " + ((Contractor)results.get(i)).getSubfield());
                subField.setBounds(20, i * 50 + 150, 200, 30);
                subField.setFont(david20);
                add(subField);

                JLabel rating = new JLabel("Rating: " + results.get(i).getRating());
                rating.setBounds(20, i * 50 + 200, 200, 30);
                rating.setFont(david20);
                add(rating);

                JButton go = new JButton("Pick");
                go.setFont(david20);
                go.setBounds(400, i * 50 + 200, 200, 30);
                add(go);
            }
        }
        else
            {
            JLabel empty = new JLabel("No matching results found");
            empty.setBounds(250, 250, 100, 100);
            empty.setFont(david50);
            add(empty);
        }

        setVisible(true);
    }

}


