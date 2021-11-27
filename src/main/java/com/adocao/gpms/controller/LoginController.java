package com.adocao.gpms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/")
    public ResponseEntity initialMessage() {
        return ResponseEntity.ok().body("<h1>Welcome</h1>");
    }

    @GetMapping("/homepage")
    public String home() {
        return "homepage";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/adote")
    public String adocao() {
        return "adocao";
    }
}
