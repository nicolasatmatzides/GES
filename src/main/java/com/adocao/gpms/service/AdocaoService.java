package com.adocao.gpms.service;

import com.adocao.gpms.entity.Adocao;
import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.entity.Usuario;
import com.adocao.gpms.model.AdocaoStatus;
import com.adocao.gpms.repository.AdocaoRepository;
import com.adocao.gpms.repository.CriancaRepository;
import com.adocao.gpms.repository.UsuarioRepository;
import com.adocao.gpms.security.UsuarioLogadoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdocaoService {

    @Autowired
    private AdocaoRepository adocaoRepository;

    @Autowired
    private CriancaRepository  criancaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Função a ser chamada pelo usuário
    public String adoteCriancaInProgress(Long id) throws Exception {
        Adocao adocao = new Adocao();
        Crianca crianca;
        try {
            crianca =  criancaRepository.findById(id).orElseThrow();
            if (crianca.getAdocaoStatus().equals(AdocaoStatus.EMPTY)){
                adocao.setCrianca(crianca);
                adocao.setAdocaoStatus(AdocaoStatus.IN_PROGRESS);
                crianca.setAdocaoStatus(AdocaoStatus.IN_PROGRESS);
                adocaoRepository.save(adocao);
                criancaRepository.save(crianca);
            }
                return "emAdamento";
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
                return "adotado";
        }catch (Exception exception){
            throw new Exception("erro ao adotar criança");
        }
    }
}
