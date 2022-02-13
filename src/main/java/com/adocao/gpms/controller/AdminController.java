package com.adocao.gpms.controller;

import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.entity.Duvida;
import com.adocao.gpms.model.login.UsuarioDTO;
import com.adocao.gpms.service.CriancaService;
import com.adocao.gpms.service.DuvidaService;
import com.adocao.gpms.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class AdminController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private DuvidaService duvidaService;

    @Autowired
    private CriancaService criancaService;

    @GetMapping("/cadastrarAdm")
    public String cadastrarUsuarioAdm() {
        return "adm/cadastroAdm.html";
    }

    @PostMapping("/novoAdm")
    public String cadastrarAdm(@RequestParam(name = "nomeCompleto") Optional<String> name,
                                      @RequestParam(name = "email") Optional<String> email,
                                      @RequestParam(name = "cpf") Optional<String> cpf,
                                      @RequestParam(name = "endereco") Optional<String> endereco,
                                      @RequestParam(name = "senha") Optional<String> senha){
        UsuarioDTO usuario = new UsuarioDTO();
        name.ifPresent(usuario::setName);
        email.ifPresent(usuario::setEmail);
        cpf.ifPresent(usuario::setCpf);
        endereco.ifPresent(usuario::setAddress);
        senha.ifPresent(usuario::setSenha);
        usuarioService.cadastrarUsuario(usuario, "ROLE_ADMIN");
        return "redirect:/usuariosCadastrados";
    }

    @GetMapping("/mensagensLista")
    public String listaDuvida(Model model){
        List<Duvida> duvidas = duvidaService.listaDuvida();
        model.addAttribute("listaDuvida", duvidas);
        return "adm/mensagens.html";
    }

    @GetMapping("/loginAdm")
    public String loginAdm(Model model){
        List<Crianca> criancaList = criancaService.listaCriancaDisponiveis();
        model.addAttribute("criancasDisponiveis", criancaList);
        return "adm/criancasAdm.html";
    }
}
