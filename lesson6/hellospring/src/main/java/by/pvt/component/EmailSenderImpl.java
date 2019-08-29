package by.pvt.component;

import by.pvt.pojo.Message;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderImpl implements EmailSender {

    public void send(Message message) {
        System.out.println("Sending message...");
        System.out.println(message);
        System.out.println("Finished sending message.");
    }
}
