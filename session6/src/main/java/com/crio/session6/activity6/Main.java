package com.crio.session6.activity6;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank acc1 = new ICICIBank();
        String option = "";
        do
        {
         System.out.println("1. DEPOSITE");
         System.out.println("2. WITHDRAW");
         System.out.println("3. BALANCE ENQUIRY");
         System.out.println("ENTER OPTION");
         option = sc.next();
         switch(option)
         {
          case "1":
          {
           System.out.println("ENTER DEPOSIT AMOUNT");
           double amt = sc.nextDouble();
           acc1.deposite(amt);
           acc1.balanceEnquiry();
           break;
          }
          case "2":
          {
           System.out.println("ENTER WITHDRAW AMOUNT");
           double amt = sc.nextDouble();
           double wd = acc1.withdraw(amt);
         System.out.println("WITHDRAW AMOUNT IS :" + wd);
           acc1.balanceEnquiry();
           break;
          }
          case"3":
          {
           acc1.balanceEnquiry();
           break;
          }
          default:
           System.out.println("INVALID OPTION");
         }
         System.out.println("DO YOU WANT TO CONTINUE (YES/NO)");
         option = sc.next();
        }while(option.equalsIgnoreCase("YES"));
        sc.close();
    }
}
