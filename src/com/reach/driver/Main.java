package com.reach.driver;

import com.reach.model.WriterReader;
import com.reach.view.*;

public class Main {

    public static void main(String[] args) {
        WriterReader initial = new WriterReader();
        initial.loadAll();
        View v1 = new MainPanel();
        v1.showScreen();
        initial.saveAll();
    }
}
