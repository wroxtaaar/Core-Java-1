package com.crio.session4.activity1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        findNameA();
        findNameAWithStream();
    }

    public static void findNameA(){
        List<Employee> employeesList = getListOfEmployees();
        List<Employee> tempList = new ArrayList<Employee>();
        
        // Complete the logic to print the list of employees whose name starts with ‘A’


        for(Employee e : tempList){
            System.out.println("Name :- " + e.getName() +" ,Designation :- " + e.getDesignation() + " , Age :- " + e.getAge());
        }
    }

    public static void findNameAWithStream(){
        List<Employee> employeesList = getListOfEmployees();
        List<String> employeeNames = employeesList.stream()
                                .map(e -> e.getName())
                                .filter(s -> s.startsWith("A"))
                               .collect(Collectors.toList());
        System.out.println(employeeNames);
    }
 
    public static List<Employee> getListOfEmployees() {
 
        List<Employee> listOfEmployees = new ArrayList<>();
 
        Employee e1 = new Employee("Mohan", 24,Arrays.asList("Newyork","Banglore"),"Manager");
        Employee e2 = new Employee("John", 27,Arrays.asList("Paris","London"),"General Manager");
        Employee e3 = new Employee("Vaibhav", 32,Arrays.asList("Pune","Seattle"),"Developer");
        Employee e4 = new Employee("Amit", 22,Arrays.asList("Chennai","Hyderabad"),"Manager");
 
        listOfEmployees.add(e1);
        listOfEmployees.add(e2);
        listOfEmployees.add(e3);
        listOfEmployees.add(e4);
 
        return listOfEmployees;
    }
}

