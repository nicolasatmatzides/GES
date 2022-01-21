package com.adocao.gpms.controller;

import com.adocao.gpms.entity.Duvida;
import com.adocao.gpms.model.DuvidaDTO;
import com.adocao.gpms.service.DuvidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DuvidaController {

    @Autowired
    private DuvidaService duvidaService;

    @GetMapping("/paginaDuvidas")
    public String paginaDuvidas() { return "adm/mensagens.html"; }

    @PostMapping("/duvidaNova")
    public String cadastraDuvida(@RequestBody String text) {
        duvidaService.cadastrarDuvida(text);
        return "/home";
    }

    @PostMapping("/duvida")
    public String respondeDuvida(DuvidaDTO duvida) {
        duvidaService.respondeDuvida(duvida);
        return "redirect:/duvidaLista";
    }

}
