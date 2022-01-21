package com.adocao.gpms.controller;

import com.adocao.gpms.entity.Duvida;
import com.adocao.gpms.model.login.UsuarioDTO;
import com.adocao.gpms.service.DuvidaService;
import com.adocao.gpms.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DuvidaService duvidaService;

    @GetMapping("/cadastrarAdm")
    public String cadastrarUsuarioAdm() {
        return "/cadastrar";
    }

    @PostMapping("/cadastrarAdm")
    public String cadastrarUsuarioAdm(UsuarioDTO dto, Model model) {
        if (!dto.getSenha().equals(dto.getConfirmacaoSenha())) {
            model.addAttribute("errorMessage", "Senha e confirmação de senha estão diferentes");
            return "/cadastrar";
        }
        usuarioService.cadastrarUsuarioAdm(dto);
        return "redirect:/home";
    }

    @GetMapping("/mensagensLista")
    public String listaDuvida(Model model){
        List<Duvida> duvidas = duvidaService.listaDuvida();
        model.addAttribute("listaDuvida", duvidas);
        return "adm/mensagens.html";
    }

    @GetMapping("/loginAdm")
    public String loginAdm(){ return "adm/criancasAdm.html"; }
}
