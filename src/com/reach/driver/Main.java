package com.reach.driver;
import com.reach.controller.MyController;
import com.reach.model.User;
import com.reach.model.WriterReader;
import com.reach.view.*;
//import com.reach.controller.*;

public class Main {


    public static void main(String[] args) {

        WriterReader intial = new WriterReader();
        intial.loadAll();

        View v1 = new MainPanel();
        v1.showScreen();

        intial.saveAll();
    }

}
