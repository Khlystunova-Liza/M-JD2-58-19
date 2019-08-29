package by.pvt.component;

import by.pvt.pojo.Message;


public interface EmailSender {

    String EMAIL_CHANNEL = "channel";

    void send(Message message);
}
