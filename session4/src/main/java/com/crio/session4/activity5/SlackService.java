package com.crio.session4.activity5;

public class SlackService implements IMessageService{

    @Override
    public void sendMessage(Message msg) {
        // TODO Auto-generated method stub
        System.out.println(msg+ " sent through Slack");
    }
    
}