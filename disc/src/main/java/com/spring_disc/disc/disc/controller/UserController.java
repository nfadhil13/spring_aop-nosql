package com.spring_disc.disc.disc.controller;

import com.spring_disc.disc.disc.model.User;
import com.spring_disc.disc.disc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping(value="/login")
    public String login(User user , ModelMap params){
        params.addAttribute("user" , user);
        return "/pages/User/login";
    }

    @GetMapping(value="/logout")
    public String logout(User user , ModelMap params){
        params.addAttribute("user" , user);
        return "/pages/User/login";
    }

    @PostMapping(value="/tryLogin")
    public String loginForm(@ModelAttribute User user , RedirectAttributes redirectAttributes){
        if(user.getUsername().equals("admin")){
            if(user.getPassword().equals("admin")){
                userService.addUser(user);
                String redirect = "redirect:/" +user.getUsername() + "/list";
                return redirect;
            }else{
                redirectAttributes.addFlashAttribute("notAvailable" , "Password Tidak Sesuai ");
                return "redirect:/login";
            }
        }else{
            redirectAttributes.addFlashAttribute("notAvailable" , "Tidak Dapat ditemukan username Tersebut ");
            return "redirect:/login";
        }


    }


    @PostMapping(value="/signup")
    public String signUp(User user){
        userService.addUser(user);
        return"";
    }

}
