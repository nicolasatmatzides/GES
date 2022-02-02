package com.adocao.gpms.controller;

import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.model.CriancaDTO;
import com.adocao.gpms.security.UsuarioLogadoSession;
import com.adocao.gpms.service.CriancaService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
                                  @RequestParam(name = "dataNascimento") Optional<String> dataNascimento,
                                  @RequestParam(name = "cpf") Optional<String> cpf,
                                  @RequestParam(name = "endereco") Optional<String> endereco,
                                  @RequestParam(name = "nomeCompletoMae") Optional<String> nomeCompletoMae,
                                  @RequestParam(name = "nomeCompletoPai") Optional<String> nomeCompletoPai){
        CriancaDTO crianca = new CriancaDTO();
//        nome.ifPresent(crianca::setName);
//        idade.ifPresent(crianca::setAge);
//        genero.ifPresent(crianca::setGender);
//        endereco.ifPresent(crianca::setAddress);
//        rg.ifPresent(crianca::setCivilId);
        return criancaService.cadastraCrianca(crianca,model);
    }
}
