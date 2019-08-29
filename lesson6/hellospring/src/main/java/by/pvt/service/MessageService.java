package by.pvt.service;

import by.pvt.cmd.SendMessageCmd;
import by.pvt.component.EmailSender;
import by.pvt.pojo.Message;
import by.pvt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Random;

//
@Service
public class MessageService {

    public final static String FROM_EMAIL = "info@gmail.com";

    //процесс поиска среди контекста наиболее подходящий тип
    @Autowired
    EmailSender emailSender;

    @Autowired
    UserRepository userRepository;

    public void executeCommand(SendMessageCmd sendMessageCmd){

        Message message = new Message();
        message.setFrom(FROM_EMAIL);
        message.setBody(sendMessageCmd.messageType.getBody());
        message.setId(new Random().nextLong());
        message.setSubject(sendMessageCmd.messageType.getSubject());
        message.setTo(userRepository.getEmailByUserName(sendMessageCmd.receiverName));

        emailSender.send(message);
    }
}
