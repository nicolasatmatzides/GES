package com.adocao.gpms.service;

import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.model.AdocaoStatus;
import com.adocao.gpms.model.CriancaDTO;
import com.adocao.gpms.repository.CriancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
public class CriancaService {
    @Autowired
    private CriancaRepository criancaRepository;

    public String cadastraCrianca(CriancaDTO criancaDTO, Model model){
        Crianca crianca = new Crianca();
        crianca.setName(criancaDTO.getName());
        crianca.setAge(criancaDTO.getAge());
        crianca.setGender(criancaDTO.getGender());
        crianca.setAdocaoStatus(AdocaoStatus.EMPTY);
        crianca.setAddress(criancaDTO.getAddress());
        crianca.setCivilId(crianca.getCivilId());
        criancaRepository.save(crianca);
        model.addAttribute("crianca", crianca);
       return "cadastrar/crianca";
    }
    public List<Crianca> listaCriancaDisponiveis() {
        List<Crianca> criancaList = new ArrayList<>();
        try {
            criancaList = criancaRepository.findAllByAdocaoStatus(AdocaoStatus.EMPTY);
        }catch (Exception e){
            e.printStackTrace();
        }
        return criancaList;
    }

    public List<Crianca> listarCriancaSucesso() {
        List<Crianca> criancaList = new ArrayList<>();
        try {
            criancaList = criancaRepository.findAllByAdocaoStatus(AdocaoStatus.COMPLETED);
        }catch (Exception e){
            e.printStackTrace();
        }
        return criancaList;
    }
}