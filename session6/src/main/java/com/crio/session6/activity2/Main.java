package com.crio.session6.activity2;

public class Main {
    public static void main(String args[])    
    {   
        try{
            Class.forName("com.opencsv.CSVParser");
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
}
