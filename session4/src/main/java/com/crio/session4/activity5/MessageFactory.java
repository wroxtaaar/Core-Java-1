package com.crio.session4.activity5;

public class MessageFactory {
    public static IMessageService createMessageService(MessageType type) {
        IMessageService messageService;
        switch(type) {
        case WHATSAPP:
            messageService = new WhatsAppService();
            break;
        case SLACK:
            messageService = new SlackService();            
            break;
        case EMAIL:
        default:
            messageService = new EmailService();
            break;
        }
        return messageService;
    }
}
