package com.adocao.gpms.controller;


import com.adocao.gpms.entity.Duvida;
import com.adocao.gpms.model.login.UsuarioDTO;
import com.adocao.gpms.service.DuvidaService;
import com.adocao.gpms.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/duvida")
@Controller
public class DuvidaController {

    @Autowired
    private DuvidaService duvidaService;

    @GetMapping("/nova")
    public String cadastrarUsuario() {
        return "duvida/nova";
    }


    @PostMapping("/nova")
    public String cadastrarUsuario(Duvida duvida) {


        duvidaService.cadastrarDuvida(duvida);

        return "redirect:/duvida/nova";
    }
}
