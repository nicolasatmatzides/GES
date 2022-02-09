package com.adocao.gpms.controller;

import com.adocao.gpms.entity.Adocao;
import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.model.AdocaoDto;
import com.adocao.gpms.model.CriancaDTO;
import com.adocao.gpms.security.UsuarioLogadoSession;
import com.adocao.gpms.service.AdocaoService;
import com.adocao.gpms.service.CriancaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller()
public class AdocaoController {

    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    @Autowired
    private AdocaoService adocaoService;

    @Autowired
    private CriancaService criancaService;

    @PostMapping("/crianca-adotar")
    public String adoteCriançaEmpty(@RequestParam(name = "id") String id) throws Exception {
        return adocaoService.adoteCriancaInProgress(id, usuarioLogadoSession);
    }

    @PostMapping("/adocaoCompleta")
    public String adoteCriançaCompleted(@RequestParam(name = "id")Optional<String> id) throws Exception {
        return adocaoService.concluiAdocao(Long.parseLong(String.valueOf(id)),usuarioLogadoSession);
    }

    @PostMapping("/adocaoCancelada")
    public String adoteCriançaCancela(@RequestParam(name = "id")Optional<String> id) throws Exception {
        return adocaoService.cancelaAdocao(Long.parseLong(String.valueOf(id)),usuarioLogadoSession);
    }

    @GetMapping("/processosAdocaoAdmin")
    public String processosAdocaoAdmin(Model model){
        List<Crianca> criancaList = criancaService.listarCriancaInProgress();
        model.addAttribute("criancasProgresso", criancaList);
        return "adm/processosAdocaoAdm.html";
    }


    @GetMapping("/paginaAdocao")
    public String paginaAdocao(Model model){
        List<Crianca> criancaList = criancaService.listarCriancaSucesso();
        model.addAttribute("criancas", criancaList);
        return "user/minhasAdocoes.html";
    }

    @GetMapping("/minhasAdocoes")
    public String minhaAdocao(Model model){
        List<Crianca> criancaList = adocaoService.minhaAdocao(usuarioLogadoSession.getId());
        model.addAttribute("minhasAdocoesList", criancaList);
        return "user/minhasAdocoes.html";
    }
}
