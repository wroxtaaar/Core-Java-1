package com.crio.session2.activity1;

import java.util.ArrayList;
import java.util.Collections;
 
public class Student
{  
    int rollNo;  
    String name;  
    int age;  
    Student(int rollno,String name,int age)
    {  
        this.rollNo=rollno;  
        this.name=name;  
        this.age=age;  
    } 

    public static void main(String args[])
    {  
        ArrayList<Student> listOfStudent = new ArrayList<Student>();  
        listOfStudent.add(new Student(1,"Ravi",26));  
        listOfStudent.add(new Student(3,"kant",27));  
        listOfStudent.add(new Student(2,"kamboj",20));  
        
		// Sort list of student objects on basis of rollNo
        bubbleSort(listOfStudent);
        
		// Print sorted result
        for(Student student:listOfStudent)
        {  
            System.out.println("RollNo of Student = "+student.rollNo);
            System.out.println("Age of Student = "+student.age);
            System.out.println("Name of Student = "+student.name);
        }
    }
    
    public static void bubbleSort(ArrayList<Student> students){
        boolean atleastOneItemisSwapped = true;
        while(atleastOneItemisSwapped){
            atleastOneItemisSwapped=false;
            //one pass
            for(int i=0; i< students.size() -1 ;i++){
                //*** comparing two elements
                int comparedResult = students.get(i).compareRollNo(students.get(i+1));
                if(comparedResult>0){
                    //swapping logic
                    Student temp = students.get(i);
                    students.set(i,students.get(i+1));
                    students.set(i+1,temp);
                    atleastOneItemisSwapped = true;
                }
            }
        }
    }

    private int compareRollNo(Student student) {
        if(rollNo == student.rollNo)  
            return 0;  
        else if(rollNo > student.rollNo)  
            return 1;  
        else  
            return -1;  
    }
}

