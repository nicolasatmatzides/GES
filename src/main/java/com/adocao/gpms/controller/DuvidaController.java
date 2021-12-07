package com.adocao.gpms.controller;


import com.adocao.gpms.entity.Duvida;
import com.adocao.gpms.model.DuvidaDTO;
import com.adocao.gpms.service.DuvidaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class DuvidaController {

    @Autowired
    private DuvidaService duvidaService;

    @GetMapping("/redirectDuvida")
    public String cadastraDuvida() {
        return "/home";
    }

    @PostMapping("/duvidaNova")
    public String cadastraDuvida(DuvidaDTO duvida) {
        duvidaService.cadastrarDuvida(duvida);
        return "/redirectDuvida";
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
