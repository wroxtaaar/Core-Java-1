package com.crio.session6.activity6;

public class ICICIBank implements Bank{
    private double balance;
    public void deposite(double amount)
    {
     if(amount <= 0)
     {
      System.out.println(amount + "is not valid");
     }
     balance = balance + amount;
    }
    public double withdraw(double amount)
    {
     if(balance < amount)
     {
        System.out.println("insufficient funds");
     }
     balance = balance - amount;
     return amount;
    }
    public void balanceEnquiry() 
    {
     System.out.println("current balance = "+ balance);
    }
}
