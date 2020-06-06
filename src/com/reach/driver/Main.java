package com.reach.driver;

import com.reach.model.WriterReader;
import com.reach.view.*;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        WriterReader initial = new WriterReader();
        initial.loadAll();
        initial.saveAll();
        View v1 = new MainPanel();
        v1.showScreen();
    }
}