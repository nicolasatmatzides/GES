package com.adocao.gpms.controller;


import com.adocao.gpms.model.login.UsuarioDTO;
import com.adocao.gpms.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/usuario")
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastrar")
    public String cadastrarUsuario() {
        return "usuario/cadastrar";
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(UsuarioDTO dto, Model model) {
        if (!dto.getSenha().equals(dto.getConfirmacaoSenha())) {
            model.addAttribute("errorMessage", "Senha e confirmação de senha estão diferentes");
            return "usuario/cadastrar";
        }

        usuarioService.cadastrarUsuario(dto);

        return "redirect:/login";
    }
}
