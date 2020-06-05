package com.reach.view;

import com.reach.controller.MyController;
import javax.swing.*;
import java.awt.*;

public class JobHistoryListScreen extends JFrame implements View
{

    @Override
    public void showScreen()
    {
        setSize(1000, 1000);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main,BoxLayout.PAGE_AXIS));
        main.setBounds(0,0,1000,1000);
        add(main);

        //Font
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david50 = new Font("David", Font.BOLD, 50);

       if (MyController.getInstance().getUserJobHistorySize(MainScreenOption.getUsername())>0)
        {
            int x = MyController.getInstance().getUserJobHistorySize(MainScreenOption.getUsername());
            for(int i=0;i<x;i++)
            {
                String desc = MyController.getInstance().HistoryDescription(MainScreenOption.getUsername(),x);
                JLabel jobDescription = new JLabel("Description: " + desc);
                jobDescription.setBounds(20, i * 50 + 100, 400, 30);
                jobDescription.setFont(david20);
                main.add(jobDescription);

                int ID = MyController.getInstance().HistoryID(MainScreenOption.getUsername(),x);
                JLabel jobID = new JLabel("Job id: " + ID);
                jobID.setBounds(20, i * 50 + 150, 200, 30);
                jobID.setFont(david20);
                main.add(jobID);

                JButton goTo = new JButton("See job details");
                goTo.setBounds(350, i * 50 + 150, 200, 30);
                goTo.setFont(david20);
                main.add(goTo);
            }
        }
        else
        {
            JLabel empty = new JLabel("No jobs to display!");
            empty.setBounds(500, 500, 100, 100);
            empty.setFont(david50);
            main.add(empty);
        }
        JScrollPane scroll = new JScrollPane(main,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setBounds(0,0,980,1000);
        add(scroll);
        setVisible(true);
    }

    public static void main(String[] args) {
        JobHistoryListScreen v = new JobHistoryListScreen();
        v.showScreen();
    }
}