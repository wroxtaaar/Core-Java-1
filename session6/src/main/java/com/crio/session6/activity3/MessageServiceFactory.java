package com.crio.session6.activity3;

public class MessageServiceFactory {
    public static IMessageService createMessageService(MessageProvider type) {
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

