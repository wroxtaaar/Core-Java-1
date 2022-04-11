package com.crio.session4.activity1;

import java.util.List;
 
public class Employee implements Comparable<Employee>{
 
    private String name;
    private int age;
    private List<String> listOfCities;
    private String designation;
 
    public Employee(String name, int age,List<String> listOfCities, String designation) {
        super();
        this.name = name;
        this.age = age;
        this.listOfCities=listOfCities;
        this.designation = designation;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public int getAge() {
        return age;
    }
 
    public void setAge(int age) {
        this.age = age;
    }
 
    public List<String> getListOfCities() {
        return listOfCities;
    }
 
    public void setListOfCities(List<String> listOfCities) {
        this.listOfCities = listOfCities;
    }

    public String getDesignation() {
        return designation;
      }
      public void setDesignation(String designation) {
        this.designation = designation;
      }
 
 
    @Override
    public String toString() {
        return "Employee [age=" + age + ", designation=" + designation + ", name=" + name + "]";
    }

    @Override
    public int compareTo(Employee o) {
        return this.getName().compareTo(o.getName());
    }
}

