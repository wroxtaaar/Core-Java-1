package com.crio.session4.activity3;

import java.util.HashSet;
import java.util.Set;

public class Student {
 
    private int id;
    private String name;
 
    public Student(int id, String name) {
        this.name = name;
        this.id = id;
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (!(obj instanceof Student))
            return false;
        if (obj == this)
            return true;
        return this.getId() == ((Student) obj).getId();
    }

 
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Set<Student> students = new HashSet<Student>();
        int counter = 100000;
		// TODO - Play with counter, try ranges between 1000 to 100000 and find out
        //  how the time taken to finish increases exponentially with increase in limit.
        for (int i = 0; i< counter; i++) {
            students.add(new Student(i, String.valueOf(i)));
        }
        System.out.println("Total time taken= " + (System.currentTimeMillis() - start));
		System.out.println("HashSet size = " + students.size());
        System.out.println("HashSet contains '1' = " + students.contains(new Student(1, "1")));
    }
}

