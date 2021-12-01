package com.adocao.gpms.controller;

import com.adocao.gpms.model.login.UsuarioDTO;
import com.adocao.gpms.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastrarAdm")
    public String cadastrarUsuarioAdm() {
        return "usuario/cadastrar";
    }

    @PostMapping("/cadastrarAdm")
    public String cadastrarUsuarioAdm(UsuarioDTO dto, Model model) {
        if (!dto.getSenha().equals(dto.getConfirmacaoSenha())) {
            model.addAttribute("errorMessage", "Senha e confirmação de senha estão diferentes");
            return "usuario/cadastrar";
        }

        usuarioService.cadastrarUsuarioAdm(dto);

        return "redirect:/login";
    }
}
