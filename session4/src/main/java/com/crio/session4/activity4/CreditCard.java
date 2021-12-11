package com.crio.session4.activity4;

public class CreditCard {
      /*
  .
  .
  Rest of the card methods
  .
  .
  */
  public void PayWithUPI(){
    UPIHandler upiHandler = new UPIHandler();
    upiHandler.payWithUPI();
  }
  public void PayWithDebitCard(){
    DebitCardHandler debitCardHandler = new DebitCardHandler();
    debitCardHandler.payWithDebitCard();
  }
  public void PayWithNetBanking(){
    NetBankingHandler netBankingHandler = new NetBankingHandler();
    netBankingHandler.payWithNetBanking();
  }
  public void PayWithPaytmWallet(){
    PaytmHandler paytmHandler = new PaytmHandler();
    paytmHandler.payWithPaytmWallet();
  }
}
