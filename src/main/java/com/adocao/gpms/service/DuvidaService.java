package com.adocao.gpms.service;

import com.adocao.gpms.entity.Duvida;
import com.adocao.gpms.entity.Usuario;
import com.adocao.gpms.model.DuvidaDTO;
import com.adocao.gpms.repository.DuvidaRepository;
import com.adocao.gpms.repository.UsuarioRepository;
import com.adocao.gpms.security.UsuarioLogadoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DuvidaService {

    @Autowired
    private DuvidaRepository duvidaRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    public Duvida cadastrarDuvida(String text) {
        Duvida duvidaNova = new Duvida();
        Optional<Usuario> usuarioOn = usuarioRepository.findById(usuarioLogadoSession.getId());
        usuarioOn.orElseThrow(() -> new UsernameNotFoundException("Not found" + usuarioLogadoSession.getId()));
        duvidaNova.setDuvida(text);
        duvidaNova.setUsuario(usuarioOn.get());
        return duvidaRepository.save(duvidaNova);
    }

    public List<Duvida> listaDuvida() {
        return duvidaRepository.findAll();
    }


    public void respondeDuvida(DuvidaDTO duvidaDTO){
        Duvida duvida = duvidaRepository.findDuvidaById(duvidaDTO.getIdDuvida());
        duvida.setResposta(duvida.getResposta());

        duvidaRepository.save(duvida);
    }


}
