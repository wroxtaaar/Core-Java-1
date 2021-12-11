package com.crio.session4.activity5;

public class Message {
    private String to;
    private String from;
    private String msg;
    
    public Message(String to, String from, String msg) {
        this.to = to;
        this.from = from;
        this.msg = msg;
    }

    public String getTo() {
        return to;
    }

    public String getFrom() {
        return from;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Message [from=" + from + ", msg=" + msg + ", to=" + to + "]";
    }

   
}
