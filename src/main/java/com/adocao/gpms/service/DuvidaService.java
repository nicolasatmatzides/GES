package com.adocao.gpms.service;

import com.adocao.gpms.entity.Duvida;
import com.adocao.gpms.entity.Usuario;
import com.adocao.gpms.repository.DuvidaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuvidaService {

    @Autowired
    private DuvidaRepository duvidaRepository;

    public void cadastrarDuvida(Duvida duvida) {

        Duvida duvidaNova = new Duvida();
        duvidaNova.setDuvida(duvida.getDuvida());

        duvidaRepository.save(duvidaNova);
    }


}
