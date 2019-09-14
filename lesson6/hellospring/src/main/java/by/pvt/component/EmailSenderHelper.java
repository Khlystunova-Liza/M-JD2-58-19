package by.pvt.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderHelper implements BeanNameAware, ApplicationContextAware,
        BeanPostProcessor,InitializingBean,DisposableBean {

    @Value("Liza")
    private String name;

    //говорит о том что этот метод будет создавать бины
    //prototype - каждый раз новый объект создается
    @Bean
    @Scope(scopeName = "prototype")
    public EmailSenderHelper getInstance(){
        return new EmailSenderHelper();
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "EmailSenderHelper{" +
                "name='" + name + '\'' +
                '}';
    }

    public void setBeanName(String s) {
        System.out.println("setBeanName:"+ s);
    }

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
    }

    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessBeforeInitialization "+o + " " + s);
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessAfterInitialization "+o + " " + s);

        return o;
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    public void destroy() throws Exception {
        System.out.println("Bean destroy");
    }
}
