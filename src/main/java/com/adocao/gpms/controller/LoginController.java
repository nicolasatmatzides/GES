package com.adocao.gpms.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.adocao.gpms.model.login.UsuarioDTO;

@Controller
public class LoginController {

    @GetMapping("/home")
    public String home() {
        return "user/home.html";
    }

    @GetMapping("/")
    public String login() {
        return "user/login.html";
    }

    @GetMapping("/como-adotar")
    public String comoAdotar() { return "user/howtoadopt"; }

    @GetMapping("/em-construcao")
    public String emContrucao() { return "build.html"; }

    @GetMapping("/error")
    public String error() { return "error.html"; }

    @GetMapping("/adote")
    public String adocao() {
        return "adocao";
    }

}
