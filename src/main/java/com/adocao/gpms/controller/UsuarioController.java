package com.adocao.gpms.controller;


import com.adocao.gpms.entity.Usuario;
import com.adocao.gpms.model.CriancaDTO;
import com.adocao.gpms.model.login.UsuarioDTO;
import com.adocao.gpms.service.DuvidaService;
import com.adocao.gpms.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Controller
public class UsuarioController {

    @Autowired
    private DuvidaService duvidaService;

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastrar")
    public String cadastrarUsuario() {
        return "user/cadastrar.html";
    }

    @PostMapping("/salvar")
    public String cadastraUsuario(Model model,
                                  @RequestParam(name = "name") Optional<String> name,
                                  @RequestParam(name = "email") Optional<String> email,
                                  @RequestParam(name = "address") Optional<String> address,
                                  @RequestParam(name = "senha") Optional<String> senha){
       UsuarioDTO usuario = new UsuarioDTO();
        name.ifPresent(usuario::setName);
        email.ifPresent(usuario::setEmail);
        address.ifPresent(usuario::setAddress);
        senha.ifPresent(usuario::setSenha);
        usuarioService.cadastrarUsuario(usuario);
        return "redirect:/";
    }

    @PostMapping("/contatoNovo")
    public String cadastraContato(@RequestBody String text) {
        duvidaService.cadastrarDuvida(text);
        return "user/home.html";
    }

    @PostMapping("/duvidaNova")
    public String cadastraDuvida(@RequestBody String text) {
        duvidaService.cadastrarDuvida(text);
        return "user/howtoadopt.html";
    }

}
