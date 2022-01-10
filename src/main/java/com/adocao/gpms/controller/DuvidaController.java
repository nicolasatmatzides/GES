package com.adocao.gpms.controller;


import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.entity.Duvida;
import com.adocao.gpms.model.DuvidaDTO;
import com.adocao.gpms.service.DuvidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/duvidaLista")
    public String listaDuvida(Model model){
        List<Duvida> duvida = duvidaService.listaDuvida();

        model.addAttribute("listaDuvida",duvida);

        return "redirect:/duvidaLista";

    }

    @PostMapping("/duvida")
    public String respondeDuvida(DuvidaDTO duvida) {


        duvidaService.respondeDuvida(duvida);

        return "redirect:/duvidaLista";
    }

}
