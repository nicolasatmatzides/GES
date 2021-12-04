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
        return "home.html";
    }

    @GetMapping("/")
    public String login() {
        return "login.html";
    }

    @GetMapping("/como-adotar")
    public String comoadotar() { return "howtoadopt.html"; }

    @GetMapping("/adote")
    public String adocao() {
        return "adocao";
    }


    @PostMapping("/login")
    public String logar(UsuarioDTO dto, Model model) {
        if (!dto.getSenha().equals(dto.getConfirmacaoSenha())) {
            model.addAttribute("errorMessage", "Email ou senha incorretos.");
            return "login.html";
        }
        return "home.html";
    }
}
