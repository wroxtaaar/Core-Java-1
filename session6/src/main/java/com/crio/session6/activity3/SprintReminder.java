package com.crio.session6.activity3;

public class SprintReminder {
    public void remind(Message message, MessageProvider messageProvider){
        IMessageService messageService = MessageServiceFactory.createMessageService(messageProvider);
        messageService.sendMessage(message);
    }

    public static void main(String[] args){
        Message whatsAppMessage = new Message("+91xxxxxxxx42", "+91xxxxxxxx89", "Session 10 is scheduled at 8pm today");
        Message slackMessage = new Message("Crio.Do", "Anonymous", "Session 10 is scheduled at 8pm today");
        Message emailMessage = new Message("session@criodo.com", "anonymous@gmail.com", "Session 10 is scheduled at 8pm today");
    
        SprintReminder sReminder = new SprintReminder();

        sReminder.remind(whatsAppMessage,MessageProvider.WHATSAPP);
        sReminder.remind(slackMessage,MessageProvider.SLACK);
        sReminder.remind(emailMessage,MessageProvider.EMAIL);
        }
}
