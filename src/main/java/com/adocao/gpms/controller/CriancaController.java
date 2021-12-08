package com.adocao.gpms.controller;

import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.model.CriancaDTO;
import com.adocao.gpms.security.UsuarioLogadoSession;
import com.adocao.gpms.service.CriancaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.google.gson.Gson;

import java.util.List;
import java.util.Optional;

@RestController
public class CriancaController {

    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    @Autowired
    private CriancaService criancaService;

    @GetMapping("crianca/cadastra")
    public String cadastraCrianca(){return "crianca/cadastrar";}



    //mostra pets disponíveis para adoção
    @GetMapping("crianca/disponiveis")
    public String listaCriancasDisponiveis(Model model){

        List<Crianca> criancaList = criancaService.listaCriancaDisponiveis();

        model.addAttribute("criancas", criancaList);

        return "crianca/lista-crianca";
    }

    //cadastrar nova criança no banco

    @GetMapping("/listarCasosSucesso")
    public String listarSucesso(Model model){
        List<Crianca> criancaList = criancaService.listarCriancaSucesso();
        model.addAttribute("criancas", criancaList);
        return "listarCasosSucesso.html";
    }

    @GetMapping("/success-case")
    public String listarCriancasAdotadas(Model model) {

        List<Crianca> criancaList = criancaService.listarCriancaSucesso();

        String json = new Gson().toJson(criancaList);

        System.out.println(json);

        return json;
    }
/*
    @PostMapping("crianca/cadastra")
    public String cadastraCrianca(Model model,
                                 @RequestParam(name = "nome") Optional<String> nome,
                                   @RequestParam(name = "idade") Optional<String> idade,
                                  @RequestParam(name = "genero") Optional<String> genero,
                                  @RequestParam(name = "endereco") Optional<String> endereco,
                                  @RequestParam(name = "rg") Optional<String> rg) throws JsonProcessingException{
        CriancaDTO crianca = new CriancaDTO();
        nome.ifPresent(crianca::setName);
        idade.ifPresent(crianca::setAge);
        genero.ifPresent(crianca::setGender);
        endereco.ifPresent(crianca::setAddress);
        rg.ifPresent(crianca::setCivilId);

        return criancaService.cadastraCrianca(crianca,model);
    }
*/

    @PostMapping("crianca/cadastra")
    public String cadastraCrianca(Model model,
                                  @RequestParam(name = "nome") Optional<String> nome,
                                  @RequestParam(name = "idade") Optional<String> idade,
                                  @RequestParam(name = "genero") Optional<String> genero,
                                  @RequestParam(name = "endereco") Optional<String> endereco,
                                  @RequestParam(name = "rg") Optional<String> rg){
        CriancaDTO crianca = new CriancaDTO();
        nome.ifPresent(crianca::setName);
        idade.ifPresent(crianca::setAge);
        genero.ifPresent(crianca::setGender);
        endereco.ifPresent(crianca::setAddress);
        rg.ifPresent(crianca::setCivilId);

        return criancaService.cadastraCrianca(crianca,model);
    }
}
