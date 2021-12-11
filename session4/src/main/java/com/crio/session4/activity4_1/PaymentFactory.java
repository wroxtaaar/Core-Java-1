package com.crio.session4.activity4_1;

public class PaymentFactory {
    public static Payment getPayment(String paymentType){
        if(paymentType == null){
           return null;
        }		
         switch(paymentType){
        case "DEBIT_CARD":
          return new DebitCardHandler();      
        case "NET_BANKING":
          return new NetBankingHandler();    
        case "UPI":
         return new UPIHandler();   
        case "PAYTM_WALLET":
         return new PaytmHandler();
      }
      return null;
     }
}
