package com.adocao.gpms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping
public class LoginController {


    @GetMapping("/homepage")
    public String home() {
        return "homepage";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login") ;
    }

    @GetMapping("/adote")
    public String adocao() {
        return "adocao";
    }
}
