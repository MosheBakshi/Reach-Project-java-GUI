package com.reach.model;
import java.io.*;

public class WriterReader {
    static int count=0;
    static File file = new File ("myObjects.txt");
    static FileOutputStream f;
    static {
        try {
            f = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    static  ObjectOutputStream o;
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

    public void save(User newuser)
    {
        User user1;
        try {
            FileInputStream fi = new FileInputStream(file);
            ObjectInputStream oi = new ObjectInputStream(fi);
            //check if user name exists
            while (file.length()>4)
            {
                user1=(User)oi.readObject();
                if(user1.name.equals(newuser.name))
                {
                    System.out.println("User name exists.");
                    return;
                }
            }
            o.writeObject(newuser);
            System.out.println("Saved "+newuser.getName());
            count++;
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public User load(String name)
    {
        User user1;
        try {
            // Read objects
            while (file.length()>4)
            {
                user1=(User)oi.readObject();
                if (user1.name.equals(name))
                {
                    System.out.println("Loaded "+user1.getName());
                    return user1;
                }
            }
            System.out.println("File empty or user name not found");
        }
        catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("Error initializing stream");
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        WriterReader writer = new WriterReader();
        User user1 = new Customer(userT.customer);
        User user2;
        user1.setName();
        writer.save(user1);
        writer.save(user1);
        user2=writer.load(user1.getName());
    }
}