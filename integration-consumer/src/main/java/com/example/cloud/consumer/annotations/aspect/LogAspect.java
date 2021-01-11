package com.example.cloud.consumer.annotations.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogAspect {

    @Around("@annotation(com.example.cloud.consumer.annotations.SystemLog)")
    public void getParams(ProceedingJoinPoint point) throws Exception {


        Object[] args = point.getArgs();
        for (Object arg : args) {
            Class<?> clazz = arg.getClass();
            Method toStringMethod = clazz.getDeclaredMethod("toString");
            if (toStringMethod == null) continue;
            Object invoke = toStringMethod.invoke(arg);
            System.out.println(invoke);
        }
        try {
            point.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

}
