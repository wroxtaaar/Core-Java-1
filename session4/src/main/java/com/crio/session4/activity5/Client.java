package com.crio.session4.activity5;

public class Client {

    public static void main(String[] args){
    Message whatsAppMessage = new Message("+91xxxxxxxx42", "+91xxxxxxxx89", "Session 10 is scheduled at 8pm today");
    Message slackMessage = new Message("Crio.Do", "Anonymous", "Session 10 is scheduled at 8pm today");
    Message emailMessage = new Message("session@criodo.com", "anonymous@gmail.com", "Session 10 is scheduled at 8pm today");

    IMessageService whatsAppMessageService = MessageFactory.createMessageService(MessageType.WHATSAPP);
    IMessageService slackMessageService = MessageFactory.createMessageService(MessageType.SLACK);
    IMessageService emailMessageService = MessageFactory.createMessageService(MessageType.EMAIL);

    whatsAppMessageService.sendMessage(whatsAppMessage);
    slackMessageService.sendMessage(slackMessage);
    emailMessageService.sendMessage(emailMessage);
    }
}
