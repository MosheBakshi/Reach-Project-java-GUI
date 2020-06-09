package com.reach.model;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class WriterReader implements Model{
    static int count = 0;
    private static final String filename = "myObjects.txt";
    public static HashMap<String,User> UsersHM = new HashMap<>();
    //add if file exits

    public static void save(User newUser) {
        User user1;
        try {
            FileOutputStream f = new FileOutputStream(filename);
            ObjectOutputStream o = new ObjectOutputStream(f);
            FileInputStream fi = new FileInputStream(filename);
            ObjectInputStream oi = new ObjectInputStream(fi);
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
            UsersHM.put(newUser.getUserName(),newUser);
            saveAll();
            System.out.println("Saved " + newUser.getUserName() + " " + newUser.getUserType());
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
            FileInputStream fi = new FileInputStream(filename);
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

    public static boolean verify(String userName, String password) {
        User user = WriterReader.UsersHM.get(userName);
        if(user == null )
            return false;
        else if(user.getPassword().equals(password))
            return true;
        else
            return false;
    }

    public static void setPhone(String name,String phone) {
        User user = WriterReader.UsersHM.get(name);
        user.setPhone(phone);
        WriterReader.save(user);
    }

    public static void setCity(String userName, String city) {
        User user = WriterReader.UsersHM.get(userName);
        user.setUserCity(city);
        WriterReader.save(user);
    }

    public static void setArea(String userName, String chooseArea) {
        User user = WriterReader.UsersHM.get(userName);
        if(user instanceof Contractor){
            Contractor c = (Contractor) user;
            c.setArea(chooseArea);
        } else {
            Freelancer f = (Freelancer) user;
            f.setArea(chooseArea);
        }
        WriterReader.save(user);
    }

    public static String getArea(String userName) {
        User user = WriterReader.UsersHM.get(userName);
        if(user instanceof Contractor){
            Contractor c = (Contractor) user;
            return c.getArea();
        } else {
            Freelancer f = (Freelancer) user;
            return f.getArea();
        }
    }

    public static void setExperience(String userName, String experience) {
        User user = WriterReader.UsersHM.get(userName);
        if(user instanceof Contractor){
            Contractor c = (Contractor) user;
            c.setYearsOfExperience(experience);
        } else {
            Freelancer f = (Freelancer) user;
            f.setYearsOfExperience(experience);
        }
        WriterReader.save(user);
    }

    public static void setField(String userName, String enterF) {
        User user = WriterReader.UsersHM.get(userName);
        if(user instanceof Contractor){
            Contractor c = (Contractor) user;
            c.setField(enterF);
        } else {
            Freelancer f = (Freelancer) user;
            f.setField(enterF);
        }
        WriterReader.save(user);
    }

    public static void setSubfield(String userName, String subfield) {
        User user = WriterReader.UsersHM.get(userName);
        if(user instanceof Contractor){
            Contractor c = (Contractor) user;
            c.setSubfield(subfield);
        } else {
            Freelancer f = (Freelancer) user;
            f.setSubfield(subfield);
        }
        WriterReader.save(user);
    }

    public static String getExperience(String userName) {
        User user = WriterReader.UsersHM.get(userName);
        if(user instanceof Contractor){
            Contractor c = (Contractor) user;
            return c.getYearsOfExperience();
        } else {
            Freelancer f = (Freelancer) user;
            return f.getYearsOfExperience();
        }
    }

    public static String getField(String userName) {
        User user = WriterReader.UsersHM.get(userName);
        if(user instanceof Contractor){
            Contractor c = (Contractor) user;
            return c.getField();
        } else {
            Freelancer f = (Freelancer) user;
            return f.getField();
        }
    }

    public static String getSubfield(String userName) {
        User user = WriterReader.UsersHM.get(userName);
        if(user instanceof Contractor){
            Contractor c = (Contractor) user;
            return c.getSubfield();
        } else {
            Freelancer f = (Freelancer) user;
            return f.getSubfield();
        }
    }

    public static String getPhone(String userName) {
        User user = WriterReader.UsersHM.get(userName);
        return user.getPhone();
    }

    public static String getCity(String userName) {
        User user = WriterReader.UsersHM.get(userName);
        return user.getUserCity();
    }

    public static UserType getUserType(String name){
        User user = WriterReader.UsersHM.get(name);
        return user.getUserType();
    }

    public static String getFirstName(String username) {
        User user = WriterReader.UsersHM.get(username);
        return user.getFirstName();
    }

    public static String getLastName(String username) {
        User user = WriterReader.UsersHM.get(username);
        return user.getLastName();
    }

    public static boolean checkFreeUserName(String userName){
        /*User user = WriterReader.load(userName);
        if(user != null){
            return false;
        }
        return true;*/
        return !(UsersHM.containsKey(userName));
    }

    //on system close
    public static void saveAll()
    {
        User user1;
        try {
            FileOutputStream f = new FileOutputStream(filename);
            ObjectOutputStream o = new ObjectOutputStream(f);
            FileInputStream fi = new FileInputStream(filename);
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
            FileInputStream fi = new FileInputStream(filename);
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

