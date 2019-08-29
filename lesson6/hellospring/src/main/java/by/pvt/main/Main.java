package by.pvt.main;

import by.pvt.cmd.SendMessageCmd;
import by.pvt.component.EmailSender;
import by.pvt.service.MessageService;
import by.pvt.service.MessageType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("by.pvt")
public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

        int beanDefinitionCount = context.getBeanDefinitionCount();
        System.out.println(beanDefinitionCount);

        String[] beanDefinitionNames = context.getBeanDefinitionNames();
        System.out.println("------beans---------");
        for (String beanDefinitionName : beanDefinitionNames) {

            System.out.println(beanDefinitionName);
        }
        System.out.println("------beans---------");


        MessageService messageService = (MessageService)context.getBean("messageService");
        System.out.println(messageService);

        messageService.executeCommand(
                new SendMessageCmd(
                        "user@gmail.ru",
                        MessageType.INVITATION_MESSAGE,
                        EmailSender.EMAIL_CHANNEL)
        );
    }
}
