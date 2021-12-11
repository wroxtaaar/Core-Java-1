package com.crio.session4.activity4_1;

public class CreditCard {
  /*
  .
  .
  Rest of the card methods
  .
  .
  */
  public void Pay(String paymentType){
    Payment payment = PaymentFactory.getPayment(paymentType);
    payment.pay();
  }

}
