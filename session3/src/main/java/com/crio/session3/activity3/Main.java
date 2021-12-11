package com.crio.session3.activity3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
        findNameAWithStreamLazyAndOrder();
    }

    public static void findNameAWithStreamLazyAndOrder(){
        List<Employee> employeesList = getListOfEmployees();
        Stream<String> employeeNamesStream = employeesList.stream()
                                .map(e -> {System.out.println("Inside Map: " + e.getName()); return e.getName(); })
                                .filter(s -> { System.out.println("Inside Filter: " + s.startsWith("A")); return s.startsWith("A"); });
        System.out.println("Calling terminal operation: collect");
        List<String> employeeNames = employeeNamesStream.collect(Collectors.toList());
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


