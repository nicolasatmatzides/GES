package com.adocao.gpms.controller;

import com.adocao.gpms.security.UsuarioLogadoSession;
import com.adocao.gpms.service.CriancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CriancasDisponiveisController {
    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    @Autowired
    private CriancaService criancaService;

    @GetMapping("/filterCriancas")
    public String criancasDisponiveis(){
        return "criancasDisponiveis.html";
    }

}
