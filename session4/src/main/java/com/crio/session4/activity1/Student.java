package com.crio.session4.activity1;

public class Student {
    
    private String firstName;
    private String lastName;
    private String email;

    public Student() {
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static void main(String args[]) {
        Student example = new Student();
        example.setFirstName("Testing");
        example.setLastName("Tester");
        example.setEmail("testing@tester.com");
        System.out.println(example);
    }
}

