package com.spring_disc.disc.disc.controller;

import com.spring_disc.disc.disc.model.Movie;
import com.spring_disc.disc.disc.model.TransactionLog;
import com.spring_disc.disc.disc.service.TransactionLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Aspect
@Component
@EnableAspectJAutoProxy
@Controller
@RequestMapping("/transaction")
public class TransactionLogController {

    @Autowired
    private TransactionLogService transactionLogService;

    @GetMapping("/{username}/list")
    public String listMovie(ModelMap params , @PathVariable("username") String username){
        params.addAttribute("listTransaction",transactionLogService.getTransaction());
        params.addAttribute("username",username);
        return "pages/TransactionLog/TransactionList";
    }




}
