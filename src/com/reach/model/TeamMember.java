package com.reach.model;

public class TeamMember implements  Model{

    protected String firstName;
    protected String lastName;
    protected int id;

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

}
/* public TeamMember setMember(){
        TeamMember member = new TeamMember();
        Scanner n = new Scanner(System.in);

        System.out.println("Enter first name: \n");
        n.next();
        member.setFirstName(n.toString());

        System.out.println("Enter last name: \n");
        n.next();
        member.setLastName(n.toString());

        System.out.println("Enter id: \n");
        n.next();
        member.setId(Integer.parseInt(n.toString()));

        return member;
    }*/