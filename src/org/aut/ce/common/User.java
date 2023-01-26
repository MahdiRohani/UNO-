package org.aut.ce.common;

public class User {
    private String firstName;
    private int age;


    public User(String firstName, int age){
        this.firstName = firstName;
        this.age = age;
    }


    public String getFirstName(){
        return firstName;
    }
    private void setFirstName(String firstName){
        this.firstName = firstName;
    }



    public int getAge(){
        return age;
    }
    public void setAge(int age){
        this.age = age;
    }



    @Override
    public String toString()
    {
        return "Person first name: " + firstName + ",  "
                +
                "Person age: " + age + ",  ";
    }


    public void print(){
        System.out.println(this.toString());
    }
}
