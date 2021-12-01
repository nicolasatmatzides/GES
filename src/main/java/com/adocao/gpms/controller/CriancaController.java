package com.adocao.gpms.controller;

import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.model.CriancaDTO;
import com.adocao.gpms.security.UsuarioLogadoSession;
import com.adocao.gpms.service.CriancaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/crianca")
public class CriancaController {

    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    @Autowired
    private CriancaService criancaService;

    @GetMapping("/cadastra")
    public String cadastraCrianca(){return "crianca/cadastrar";}



    //mostra pets disponíveis para adoção
    @GetMapping("/disponiveis")
    public String listaCriancasDisponiveis(Model model){

        List<Crianca> criancaList = criancaService.listaCriancaDisponiveis();

        model.addAttribute("criancas", criancaList);

        return "crianca/lista-crianca";
    }

    //cadastrar nova criança no banco

    @GetMapping("/listarSucesso")
    public String listarSucesso(Model model){
        List<Crianca> criancaList = criancaService.listarCriancaSucesso();

        model.addAttribute("criancas", criancaList);

        return "crianca/sucesso";
    }

    @PostMapping
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

}
