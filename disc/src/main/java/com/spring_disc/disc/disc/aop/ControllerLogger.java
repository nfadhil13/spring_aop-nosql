package com.spring_disc.disc.disc.aop;

import com.spring_disc.disc.disc.model.TransactionLog;
import com.spring_disc.disc.disc.model.User;
import com.spring_disc.disc.disc.service.TransactionLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;

@Aspect
@Configuration
public class ControllerLogger {

//    private Logger logger;
//
//    @After("execution(* com..spring_disc.disc.disc.controller.MasterMovieController.*(..))")
//    public void loggingMovieController(JoinPoint joinPoint){
//
//            //Advice
//        Object[] objects = joinPoint.getArgs();
//        String username = (String) objects[objects.length-1];
//        logger = Logger.getLogger(joinPoint.getTarget().getClass().getName());
//        logger.log(Level.INFO , "\n Doing :" + joinPoint.getSignature().getName() + "\n" +
//                "BY :" + username);
//
//    }
//
//    @After("execution(* com..spring_disc.disc.disc.controller.UserController.*(..))")
//    public void loggingUserController(JoinPoint joinPoint){
//
//        //Advice
//        Object[] objects = joinPoint.getArgs();
//        User user = (User) objects[0];
//        logger = Logger.getLogger(joinPoint.getTarget().getClass().getName());
//        logger.log(Level.INFO , "\n Doing :" + joinPoint.getSignature().getName() + "\n" +
//                "BY :" + user.getUsername());
//
//    }

}
