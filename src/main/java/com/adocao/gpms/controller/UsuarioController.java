package com.adocao.gpms.controller;


import com.adocao.gpms.entity.Usuario;
import com.adocao.gpms.model.login.UsuarioDTO;
import com.adocao.gpms.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/cadastrar")
    public String cadastrarUsuario() {
        return "cadastrar.html";
    }

    @PostMapping("/cadastrar")
    public String cadastrarUsuario(@RequestBody HashMap<String, String> infoUsuario) {
        if (!infoUsuario.get("senha").equals(infoUsuario.get("confirmacaoSenha"))) {
            return "/cadastrar";
        }
        Usuario usuario = new Usuario();
        usuario.setName(infoUsuario.get("name"));
        usuario.setEmail(infoUsuario.get("email"));
        usuario.setAddress(infoUsuario.get("address"));
        usuario.setPassword(infoUsuario.get("senha"));

        UsuarioDTO dto = new UsuarioDTO();
        usuarioService.cadastrarUsuario(dto);
        return "redirect:/";
    }


}
