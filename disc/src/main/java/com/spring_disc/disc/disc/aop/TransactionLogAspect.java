package com.spring_disc.disc.disc.aop;

import com.spring_disc.disc.disc.model.Movie;
import com.spring_disc.disc.disc.model.TransactionLog;
import com.spring_disc.disc.disc.service.TransactionLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

@Aspect
@Configuration
public class TransactionLogAspect {

    @Autowired
    private TransactionLogService transactionLogService;

    @AfterReturning("execution(* com..spring_disc.disc.disc.controller.MasterMovieController.submitRent(..))")
    public void afterRent(JoinPoint joinPoint){

        Object[] objects = joinPoint.getArgs();
        TransactionLog transactionLog = (TransactionLog) objects[0];
        String code = LocalDate.now().toString().replace("-","")+ transactionLog.getCodeDVD();
        transactionLog.setAvailable(false);
        transactionLog.setCode(code);
        transactionLog.setStartDate(LocalDate.now());
        transactionLog.setEndDate(LocalDate.now().plusDays(transactionLog.getRentDays()));
        transactionLogService.newTransaction(transactionLog);


    }

    @AfterReturning("execution(* com..spring_disc.disc.disc.controller.MasterMovieController.returnDVD(..))")
    public void afterReturnDVD(JoinPoint joinPoint){

        TransactionLog transactionLog = null;
        boolean found =false;

        Object[] objects = joinPoint.getArgs();
        String dvdCode = (String) objects[1];


        List<TransactionLog> transactionLogList = new ArrayList<>(transactionLogService.getTransaction());

        for(int i=0;i<transactionLogList.size();i++){
            boolean isAvail = transactionLogList.get(i).isAvailable();
            boolean isSameCode = transactionLogList.get(i).getCodeDVD().equals(dvdCode);
            if(!isAvail && isSameCode ){
                transactionLog = transactionLogList.get(i);
                found = true;
                break;
            }
        }

        if(found){
            transactionLog.setAvailable(true);
            transactionLog.setEndDate(LocalDate.now());
            transactionLog.setRentDays(Math.abs((int)(DAYS.between(LocalDate.now(),transactionLog.getStartDate()))));
            transactionLogService.newTransaction(transactionLog);
        }

    }

    @AfterReturning("execution(* com..spring_disc.disc.disc.controller.MasterMovieController.deleteMovieById(..))")
    public void afterDeleteDVD(JoinPoint joinPoint){
        Object[] objects = joinPoint.getArgs();
        String id = (String) objects[0];

        List<TransactionLog> transactionLogList = new ArrayList<>(transactionLogService.getTransaction());
        for(int i=0; i<transactionLogList.size();i++){
            System.out.println(transactionLogList.get(i).getMovieCode() + " : " +id);
            if(transactionLogList.get(i).getMovieCode().equals(id)){
                transactionLogList.get(i).setAvailable(true);
                transactionLogService.newTransaction(transactionLogList.get(i));
            }
        }
    }

    @AfterReturning("execution(* com..spring_disc.disc.disc.controller.MasterMovieController.sumbitEditMovie(..))")
    public void afterEditDVD(JoinPoint joinPoint){
        Object[] objects = joinPoint.getArgs();
        String id = (String) objects[1];
        Movie movie = (Movie) objects[0];
        List<TransactionLog> transactionLogList = new ArrayList<>(transactionLogService.getTransaction());
        for(int i=0; i<transactionLogList.size();i++){
            System.out.println(transactionLogList.get(i).getMovieCode() + " : " +id);
            if(transactionLogList.get(i).getMovieCode().equals(id)){
                transactionLogList.get(i).setMovieTitle(movie.getTitle());
                String idDVD = movie.getTitle().replace(" ","").concat(String.valueOf(i));
                transactionLogList.get(i).setCodeDVD(idDVD);
                transactionLogService.newTransaction(transactionLogList.get(i));
            }
        }
    }

}
