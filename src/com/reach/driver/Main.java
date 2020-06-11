package com.reach.driver;

import com.reach.model.WriterReader;
import com.reach.view.*;

import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{
    public static WriterReader initial = new WriterReader();
    @Override
    public int getDefaultCloseOperation() {
        initial.saveAll();
        return super.getDefaultCloseOperation();
    }

    public static void main(String[] args) {
        initial.loadAll();
        View v1 = new MainPanel();
        v1.showScreen();
    }
}