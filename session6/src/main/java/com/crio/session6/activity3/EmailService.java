package com.crio.session6.activity3;

public class EmailService implements IMessageService {

    @Override
    public void sendMessage(Message msg) {
        // TODO Auto-generated method stub
        System.out.println(msg+ " sent through email");   
    }
    
}

