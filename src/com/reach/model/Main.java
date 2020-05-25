package com.reach.model;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // First choice of user type for creating object.
        Scanner userchoice = new Scanner(System.in);
        userT choice = null;
        System.out.println("Please choose you user type: ");
        System.out.println("                             1) Customer ");
        System.out.println("                             2) Freelancer ");
        System.out.println("                             3) Contractor ");
        int i = userchoice.nextInt();
        switch(i) {
            case 1:
                choice = userT.customer;
                break;
            case 2:
                choice = userT.freelancer;
                break;
            case 3:
                choice = userT.contractor;
                break;
        }
        System.out.println("Your choice is: "
                + choice.toString().toUpperCase().charAt(0)
                +  choice.toString().substring(1));

        switch(choice) {
            case customer:
                Customer customerCreate = new Customer(choice);
                break;
            case freelancer:
                Freelancer freelancerCreate = new Freelancer(choice);
                break;
            case contractor:
                Contractor contractorCreate = new Contractor(choice);
                break;
        }
    }
}
