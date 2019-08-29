package by.pvt;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    //перед вызовом каждого публичного метода - вызывать метод log()
    @Before("execution(public * * (..))")
    public void log(JoinPoint joinPoint){
        String name = joinPoint.getSignature().getName();
        Object target = joinPoint.getTarget();
        System.out.println("LoggingAspect.log() " + name +" " + target);

    }
}
