package com.reach.model;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class WriterReader implements Model{
    static int count = 0;
    static File file = new File("MyObjects.txt");
    public HashMap<String,User> UsersHM = new HashMap<>();
    //add if file exits

    static FileOutputStream f;

    static {
        try {
            f = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static ObjectOutputStream o;
    static {
        try {
            o = new ObjectOutputStream(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static FileInputStream fi;
    static {
        try {
            fi = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static ObjectInputStream oi;
    static {
        try {
            oi = new ObjectInputStream(fi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void save(User newUser) {
        User user1;
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            //check if user name exists
            while (fi.available()>4)
            {
                user1 = (User) oi.readObject();
                if (user1.userName.equals(newUser.userName))
                {
                    System.out.println("User name exists.");
                    return;
                }
            }
            newUser.setUserId(count++);
            o.writeObject(newUser);
            System.out.println("Saved " + newUser.getUserName() +" "+ newUser.getUserType());
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static User load(String name){
        User user1;
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            // Read objects
            while (fi.available()>4)
            {
                user1 = (User)oi.readObject();
                if (user1.userName.equals(name)) {
                    System.out.println("Loaded " + user1.getUserName());
                    return user1;
                }
            }
            System.out.println("File empty or user name not found");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean equals(Object obj){
        if(this == obj)
            return true;
        else
            return false;
    }

    public static boolean verify(String userName, String password) {
        User user = WriterReader.load(userName);
        if(user == null )
            return false;
        else if(user.getPassword().equals(password))
            return true;
        else
            return false;
    }

    public static boolean checkFreeUserName(String userName){
        User user = WriterReader.load(userName);
        if(user != null){
            return false;
        }
        return true;
    }

    //on system close
    public void saveAll()
    {
        User user1;
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            ArrayList<String> keys = new ArrayList<>(UsersHM.keySet());
            int i = 0;
            while (i<keys.size())
            {
                user1 = UsersHM.get(keys.get(i++));
                o.writeObject(user1);
            }
            System.out.println("File empty or user name not found");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        }
    }

    //on system open
    public void loadAll()
    {
        User user1;
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            while (fi.available()>4)
            {
                user1 = (User)oi.readObject();
                UsersHM.put(user1.userName,user1);
            }
            System.out.println("File empty or user name not found");
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

}