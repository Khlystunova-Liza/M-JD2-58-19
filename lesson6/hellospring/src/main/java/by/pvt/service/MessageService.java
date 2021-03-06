package by.pvt.service;

import by.pvt.cmd.SendMessageCmd;
import by.pvt.component.EmailSender;
import by.pvt.pojo.Message;
import by.pvt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class MessageService {

    public final static String FROM_EMAIL = "info@gmail.com";

    //процесс поиска среди контекста наиболее подходящий тип
    @Autowired
    @Qualifier("myEmailSender")
    EmailSender emailSender;

    @Autowired
    UserRepository userRepository;

    public void executeCommand(SendMessageCmd sendMessageCmd){

        Message message = new Message();
        message.setFrom(FROM_EMAIL);
        message.setBody(String.format(sendMessageCmd.messageType.getBody(),
                sendMessageCmd.receiverName));
        message.setId(new Random().nextLong());
        message.setSubject(sendMessageCmd.messageType.getSubject());
        message.setTo(userRepository.getEmailByUserName(sendMessageCmd.receiverName));
        emailSender.send(message);
    }
}
