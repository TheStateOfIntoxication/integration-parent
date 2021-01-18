package com.example.cloud.consumer.aop;

import com.example.cloud.consumer.repository.UserRepository;
import com.example.cloud.pojo.aop.annotations.Validation;
import com.example.cloud.pojo.entity.User;
import com.example.cloud.pojo.model.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class LogAspect {

    @Autowired
    private UserRepository userRepository;


    @Around("@annotation(com.example.cloud.pojo.aop.annotations.Check)")
    public Object getParams(ProceedingJoinPoint point) throws Throwable {
        Object arg = point.getArgs()[0];
        Class<?> clazz = arg.getClass();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            Validation validation = field.getDeclaredAnnotation(Validation.class);
            if (validation == null) {continue;}
            String str = field.get(arg).toString();
            if ("id".equals(field.getName())) {
                boolean aNull = isNull(str);
                if (aNull) {return Result.create(Result.OK, "无此数据:"+field.get(arg), null);}
            }

            String value = validation.value();
            if (StringUtils.isEmpty(value)) {continue;}
            if (!str.matches(value)){
                return Result.create(Result.OK, field.getName()+"验证未通过"+value, null);
            }

        }
        return point.proceed();
    }

    private boolean isNull(String id){
        List<String> idList = new ArrayList<>();
        idList.add(id);
        List<User> userList = userRepository.findByIdIn(idList);
        return userList.isEmpty();
    }



}
