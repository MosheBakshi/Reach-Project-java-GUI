package com.reach.model;
import java.io.*;

public class WriterReader implements  Model{
    static int count = 0;
    static File file = new File("MyObjects.txt");
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
        if(user.getPassword().equals(password))
            return true;
        else
            return false;
    }

/*
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        WriterReader writer = new WriterReader();
        User user1 = new Customer(UserType.customer,"aaa");
        User user2 = new Contractor(UserType.contractor,"bbb");
        User user3 = new Freelancer(UserType.freelancer,"ccc");
        writer.save(user1);
        writer.save(user2);
        writer.save(user3);
        User user4;
        user4=writer.load(user1.getUserName());
        System.out.print(user2.getUserCell());
        user4=writer.load(user2.getUserName());
        System.out.print(user4.getUserCell());
        user4=writer.load(user3.getUserName());
        System.out.print(user4.getUserCell());
    }*/
}