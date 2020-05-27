package com.reach.model;
import java.io.*;

public class WriterReader implements Model{
    static int count = 0;
    static File file = new File("myObjects.txt");
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
            while (file.length() > 4) {
                user1 = (User) oi.readObject();
                if (user1.userName.equals(newUser.userName)) {
                    System.out.println("User name exists.");
                    return;
                }
            }
            o.writeObject(newUser);
            System.out.println("Saved " + newUser.getUserName() +" "+ newUser.getUserType());
            count++;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public User load(String name) {
        User user1;
        try {
            // Read objects
            while (file.length() > 4) {
                user1 = (User) oi.readObject();
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


  /*  public static void main(String[] args) throws IOException, ClassNotFoundException {
        WriterReader writer = new WriterReader();
        User user1 = new Customer(UserType.customer,"aaaa");
        User user2;
        user1.setUserName("aaa");
        user1.setCell("0521111111");
        writer.save(user1);
        writer.save(user1);
        user2=writer.load(user1.getUserName());
        System.out.print(user2.getUserCell());
    }*/
}