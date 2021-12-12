package com.crio.session6.activity3;

public class Main {
    public static void main(String args[])    
    {
        String name = null;
        try{
            if (name.equals("Crio.Do")){
                System.out.println("Match Found!");
            }
            else{
                System.out.println("No Match Found!");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }   
}
