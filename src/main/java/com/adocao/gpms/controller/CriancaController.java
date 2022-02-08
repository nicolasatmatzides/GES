package com.adocao.gpms.controller;

import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.model.AdocaoStatus;
import com.adocao.gpms.model.CriancaDTO;
import com.adocao.gpms.security.UsuarioLogadoSession;
import com.adocao.gpms.service.CriancaService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CriancaController {

    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    @Autowired
    private CriancaService criancaService;

    @GetMapping("crianca/paginaCadastrar")
    public String cadastraCrianca(){return "adm/cadastroCrianca.html";}

    @GetMapping("crianca/excluir")
    public String excluirCrianca(){
        return "redirect:/loginAdm";
    }

    @GetMapping("crianca/editar")
    public String editarCrianca(){
        return "adm/editaCrianca.html";
    }

    @GetMapping("/busca")
    public String busca(Model model,
                        @RequestParam(name = "idade") String idade,
                        @RequestParam(name = "sexo") String genero) {

        List<Crianca> criancaList = criancaService.busca(idade, genero);

        model.addAttribute("criancas", criancaList);

        return "user/result";

    }

    @GetMapping("/casos-sucesso")
    public String listarCasosSucessos(Model model){
        List<Crianca> criancaList = criancaService.listarCriancaSucesso();
        model.addAttribute("criancas", criancaList);
        return "user/success.html";
    }

    @PostMapping("cadastroCrianca")
    public String cadastraCrianca(Model model,
                                  @RequestParam(name = "nomeCompleto") Optional<String> nome,
                                  @RequestParam(name = "idade") Optional<String> idade,
                                  @RequestParam(name = "genero") Optional<String> genero,
                                  @RequestParam(name = "cpf") Optional<String> cpf,
                                  @RequestParam(name = "endereco") Optional<String> endereco,
                                  @RequestParam(name = "nomeCompletoMae") Optional<String> nomeCompletoMae,
                                  @RequestParam(name = "nomeCompletoPai") Optional<String> nomeCompletoPai){
        CriancaDTO crianca = new CriancaDTO();
        nome.ifPresent(crianca::setName);
        idade.ifPresent(crianca::setAge);
        genero.ifPresent(crianca::setGender);
        cpf.ifPresent(crianca::setCPF);
        endereco.ifPresent(crianca::setAddress);
        nomeCompletoMae.ifPresent(crianca::setNomeCompletoMae);
        nomeCompletoPai.ifPresent(crianca::setNomeCompletoPai);
        criancaService.cadastraCrianca(crianca, model);
        return "redirect:/loginAdm";
    }
    @PostMapping("/deletaCrianca")
    public String Deleta(@RequestParam("id") String id){
        System.out.println(id);
        criancaService.excluiCrianca(Long.parseLong(String.valueOf(id)));
        return "redirect:/loginAdm";
    }

    @PostMapping("/editaCrianca")
    public String editaCrianca(Model model,
                                  @RequestParam(name = "nomeCompleto") Optional<String> nome,
                                  @RequestParam(name = "idade") Optional<String> idade,
                                  @RequestParam(name = "genero") Optional<String> genero,
                                  @RequestParam(name = "cpf") Optional<String> cpf,
                                  @RequestParam(name = "endereco") Optional<String> endereco,
                                  @RequestParam(name = "status") Optional<AdocaoStatus> adocaoStatus,
                                  @RequestParam(name = "nomeCompletoMae") Optional<String> nomeCompletoMae,
                                  @RequestParam(name = "nomeCompletoPai") Optional<String> nomeCompletoPai){
        CriancaDTO crianca = new CriancaDTO();
        nome.ifPresent(crianca::setName);
        idade.ifPresent(crianca::setAge);
        genero.ifPresent(crianca::setGender);
        cpf.ifPresent(crianca::setCPF);
        endereco.ifPresent(crianca::setAddress);
        adocaoStatus.ifPresent(crianca::setAdocaoStatus);
        nomeCompletoMae.ifPresent(crianca::setNomeCompletoMae);
        nomeCompletoPai.ifPresent(crianca::setNomeCompletoPai);
        criancaService.editaCrianca(crianca, model);
        return "redirect:/loginAdm";
    }
}
