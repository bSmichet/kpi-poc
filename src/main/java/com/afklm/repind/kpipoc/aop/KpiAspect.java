package com.afklm.repind.kpipoc.aop;

import com.afklm.repind.kpipoc.annotation.Kpi;
import com.afklm.repind.kpipoc.model.Activity;
import com.afklm.repind.kpipoc.repository.ActivityRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Date;

/**
 * Aspect for logging execution of Web REST endpoints.
 */
@Slf4j
@AllArgsConstructor
@Component
@Aspect
public class KpiAspect {
    private final ActivityRepository activityRepository;

    @After(value = "@annotation(com.afklm.repind.kpipoc.annotation.Kpi)")
    public void getAccountOperationInfo(JoinPoint joinPoint) {

        // Method Information
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();

        log.info("full method description: ", signature.getMethod());
        log.info("method name: ", signature.getMethod().getName());
        log.info("declaring type: ", signature.getDeclaringType());

        // Method args
        log.info("Method args names:");
        Arrays.stream(signature.getParameterNames())
                .forEach(s -> log.info("arg name: ", s));

        log.info("Method args types:");
        Arrays.stream(signature.getParameterTypes())
                .forEach(s -> log.info("arg type: ", s));

        log.info("Method args values:");
        Arrays.stream(joinPoint.getArgs())
                .forEach(o -> log.info("arg value: ", o.toString()));

        // Additional Information
        log.info("returning type: ", signature.getReturnType());
        log.info("method modifier: ", Modifier.toString(signature.getModifiers()));
        Arrays.stream(signature.getExceptionTypes())
                .forEach(aClass -> log.info("exception type: ", aClass));

        // Method annotation
        Method method = signature.getMethod();
        Kpi accountOperation = method.getAnnotation(Kpi.class);
        log.info("Account operation annotation: ", accountOperation);
        log.info("Account operation value: ", accountOperation.action());

        // Create Activity and save it
        Activity activity = new Activity();
        activity.setAction(accountOperation.action().getValue());
        activity.setGin(joinPoint.getArgs()[0].toString());
        activity.setType(joinPoint.getArgs()[1].toString());
        activity.setCreator(joinPoint.getArgs()[2].toString());
        activity.setDate(new Date());
        activityRepository.save(activity);
    }
}
