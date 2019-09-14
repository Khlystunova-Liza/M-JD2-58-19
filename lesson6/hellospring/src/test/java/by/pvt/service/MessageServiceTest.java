package by.pvt.service;

import by.pvt.cmd.SendMessageCmd;
import by.pvt.component.EmailSender;
import by.pvt.main.Main;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = Main.class)
public class MessageServiceTest {

    @Autowired
    MessageService messageService;

    @org.junit.Test
    public void executeCommand1() {
        System.out.println(messageService);
        messageService.executeCommand(new SendMessageCmd(
                "test@gmail.ru",
                MessageType.INVITATION_MESSAGE,
                EmailSender.EMAIL_CHANNEL)
        );

    }

     @Test(expected = NullPointerException.class)
    public void executeCommand2() {
       messageService.executeCommand(null);
    }

    @Test
    public void executeCommand3(){
    SendMessageCmd sendMessageCmd = new SendMessageCmd(
            "Ivan Ivanov",
            MessageType.INVITATION_MESSAGE,
            "Email"
    );

    messageService.executeCommand(sendMessageCmd);
    }

    }