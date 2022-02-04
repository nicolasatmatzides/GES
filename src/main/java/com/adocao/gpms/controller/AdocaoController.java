package com.adocao.gpms.controller;

import com.adocao.gpms.security.UsuarioLogadoSession;
import com.adocao.gpms.service.AdocaoService;
import com.adocao.gpms.service.CriancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class AdocaoController {

    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    @Autowired
    private AdocaoService adocaoService;

    @PutMapping("/adocaoEmAndamento")
    public String adoteCriançaEmpty(@RequestParam(name = "id")Optional<String> id) throws Exception {

        return adocaoService.adoteCriancaInProgress(Long.parseLong(String.valueOf(id)));
    }

    @PutMapping("/adocaoCompleta")
    public String adoteCriançaCompleted(@RequestParam(name = "id")Optional<String> id) throws Exception {

        return adocaoService.concluiAdocao(Long.parseLong(String.valueOf(id)),usuarioLogadoSession);
    }

}
