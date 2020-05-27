package com.reach.view;

import com.reach.controller.ButtonListener;

import javax.swing.*;
import java.awt.*;

public class MainScreenLogIn extends JFrame implements  View{

    private String username;
    private static JComboBox professional;
    private static JComboBox areaBox;


    public MainScreenLogIn(String userName){
        this.username=userName;
    }

    public String getUsername() {
        return username;
    }

    public static String getAreaBox() {
        return (String) areaBox.getSelectedItem();
    }

    public static String getProfessional() {
        return (String) professional.getSelectedItem();
    }

    @Override
    public void showScreen() {

        setSize(700, 600);
        setLayout(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //Font
        Font david30 = new Font("David", Font.BOLD, 30);
        Font david20 = new Font("David", Font.BOLD, 20);
        Font david15 = new Font("forget a password", Font.PLAIN, 15);


        //Labels and Buttons
        JLabel userName = new JLabel("Hello " + getUsername());
        userName.setBounds(265, 105, 400, 100);
        userName.setFont(david20);
        add(userName);
        JLabel whatAreYouLookingFor = new JLabel("What Are You Looking For :");
        whatAreYouLookingFor.setBounds(190, 150, 450, 100);
        whatAreYouLookingFor.setFont(david20);
        add(whatAreYouLookingFor);

        String[] optionBox = {"Profession","Electrician","Handyman","Technician"};
        professional = new JComboBox(optionBox);
        professional.setBounds(130, 240, 100, 20);
        add(professional);
        String[] area = {"Area","center","north","south","west"};
        areaBox = new JComboBox(area);
        areaBox.setBounds(255, 240, 100, 20);
        add(areaBox);
        JButton search = new JButton("Search");
        search.setBounds(375, 240, 110, 20);
        search.addActionListener(new ButtonListener(this));
        add(search);

        //Bg
        ImageIcon background_image = new ImageIcon("LogInBG.png");
        Image img = background_image.getImage();
        Image tmp_img = img.getScaledInstance(700, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(tmp_img);
        JLabel background = new JLabel("", background_image, JLabel.CENTER);
        background.setBounds(0, 0, 700, 600);
        add(background);


        setVisible(true);
    }

}
