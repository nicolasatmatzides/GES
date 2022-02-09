package com.adocao.gpms.service;

import com.adocao.gpms.entity.Adocao;
import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.entity.Usuario;
import com.adocao.gpms.model.AdocaoStatus;
import com.adocao.gpms.model.CriancaDTO;
import com.adocao.gpms.repository.AdocaoRepository;
import com.adocao.gpms.repository.CriancaRepository;
import com.adocao.gpms.repository.UsuarioRepository;
import com.adocao.gpms.security.UsuarioLogadoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AdocaoService {
    @Autowired
    private LoginService loginService;

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private CriancaRepository  criancaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Função a ser chamada pelo usuário
    public String adoteCriancaInProgress(String id, UsuarioLogadoSession usuarioLogadoSession) throws Exception {
        Usuario usuario;
        Adocao adocao = new Adocao();
        Crianca crianca;
        usuario = usuarioRepository.findById(usuarioLogadoSession.getId()).orElseThrow();
        try {
            crianca =  criancaRepository.findById(Long.parseLong(String.valueOf(id))).orElseThrow();
            if (crianca.getAdocaoStatus().equals(AdocaoStatus.EMPTY)){
                adocao.setCrianca(crianca);
                adocao.setAdocaoStatus(AdocaoStatus.IN_PROGRESS);
                crianca.setAdocaoStatus(AdocaoStatus.IN_PROGRESS);
                adocao.setUsuario(usuario);
                criancaRepository.save(crianca);
                adocaoRepository.save(adocao);
            }
            return "redirect:/minhasAdocoes";
        }catch (Exception exception){
            throw new Exception("erro ao adotar criança");
        }
    }

    //Função usada pelo adm, apenas passar id da criança
    public String concluiAdocao(Long id, UsuarioLogadoSession usuarioLogadoSession) throws Exception {
        Usuario usuario;
        Adocao adocao = new Adocao();
        Crianca crianca;

        usuario = usuarioRepository.findById(usuarioLogadoSession.getId()).orElseThrow();
        try {
            crianca =  criancaRepository.findById(id).orElseThrow();
            if (crianca.getAdocaoStatus().equals(AdocaoStatus.IN_PROGRESS) && usuario.getRole().equals("ROLE_ADMIN")){
                adocao.setCrianca(crianca);
                adocao.setAdocaoStatus(AdocaoStatus.COMPLETED);
                crianca.setAdocaoStatus(AdocaoStatus.COMPLETED);
                adocaoRepository.save(adocao);
                criancaRepository.save(crianca);
            }
                return "redirect:/processosAdocaoAdmin";
        }catch (Exception exception){
            throw new Exception("erro ao adotar criança");
        }
    }

    public List<Crianca> minhaAdocao(Long id) {
        List<Adocao> adocaoArrayList = adocaoRepository.findAllCriancaByUsuarioId(id);
        List<Crianca> criancaList = new ArrayList<>();
              for (int i = 0; i < adocaoArrayList.size(); i++) {
                  criancaList.add(adocaoArrayList.get(i).getCrianca());
              }
        return criancaList;
    }

    public String cancelaAdocao(String id, UsuarioLogadoSession usuarioLogadoSession) throws Exception {

        Crianca crianca;
        try {
            crianca =  criancaRepository.findById(Long.parseLong(String.valueOf(id))).orElseThrow();
            if (crianca.getAdocaoStatus().equals(AdocaoStatus.IN_PROGRESS)){
                crianca.setAdocaoStatus(AdocaoStatus.EMPTY);
                criancaRepository.save(crianca);
            }
            return "redirect:/minhasAdocoes";
        }catch (Exception exception){
            throw new Exception("erro ao adotar criança");
        }
    }

    public String reprovarAdocao(String id, UsuarioLogadoSession usuarioLogadoSession) throws Exception {

        Crianca crianca;
        try {
            crianca =  criancaRepository.findById(Long.parseLong(String.valueOf(id))).orElseThrow();
            if (crianca.getAdocaoStatus().equals(AdocaoStatus.IN_PROGRESS)){
                crianca.setAdocaoStatus(AdocaoStatus.EMPTY);
                criancaRepository.save(crianca);
            }
            return "redirect:/processosAdocaoAdmin";
        }catch (Exception exception){
            throw new Exception("erro ao adotar criança");
        }
    }
}
