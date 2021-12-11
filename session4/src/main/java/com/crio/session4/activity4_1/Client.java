package com.crio.session4.activity4_1;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
      CreditCard c = new CreditCard();
      Scanner sc = new Scanner(System.in);
      System.out.println("Pay Credit Card bill");
      System.out.println("Choose your option:");
      System.out.println("1)Pay using Debit Card");
      System.out.println("2)Pay using Net Banking");
      System.out.println("3)Pay using UPI");
      System.out.println("4)Pay using Paytm Wallet");
      Integer option = sc.nextInt();
      switch(option){
        case 1:
          c.Pay("DEBIT_CARD");
          break;
        case 2:
          c.Pay("NET_BANKING");
          break;
        case 3:
          c.Pay("UPI");
          break;
        case 4:
          c.Pay("PAYTM_WALLET");
          break;
      }
      sc.close();
    }
}
