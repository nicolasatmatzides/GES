package com.adocao.gpms.service;

import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.model.AdocaoStatus;
import com.adocao.gpms.model.CriancaDTO;
import com.adocao.gpms.repository.CriancaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
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
       return "cadastroCrianca";
    }

    public String editaCrianca(CriancaDTO criancaDTO, Model model){
        Crianca crianca = new Crianca();
        crianca.setName(criancaDTO.getName());
        crianca.setAge(criancaDTO.getAge());
        crianca.setGender(criancaDTO.getGender());
        crianca.setAdocaoStatus(criancaDTO.getAdocaoStatus());
        crianca.setAddress(criancaDTO.getAddress());
        crianca.setCivilId(crianca.getCivilId());
        criancaRepository.save(crianca);
        model.addAttribute("crianca", crianca);
        return "editarCrianca";
    }

    public CriancaDTO infoCrianca(Long id){
        CriancaDTO crianca = criancaRepository.findById(id).orElseThrow();
        return crianca;
    }

    public void excluiCrianca(Long id){
        try{
        Crianca crianca  = criancaRepository.findById(id).orElseThrow();
        criancaRepository.delete(crianca);
        }catch (Exception exception){
            exception.printStackTrace();
        }
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

    public List<Crianca> listarCriancaInProgress() {
        List<Crianca> criancaList = new ArrayList<>();
        try {
            criancaList = criancaRepository.findAllByAdocaoStatus(AdocaoStatus.IN_PROGRESS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return criancaList;
    }

    public List<Crianca> busca(String age, String gender) {
        List<Crianca> criancaList = new ArrayList<>();
        try {
            if(gender.equals("INDIFERE")) {
                return filterByAge(age, criancaRepository.findAllByAdocaoStatus(AdocaoStatus.EMPTY));
            }else
                criancaList = filterByAge(age, criancaRepository.findAllByGenderAndAdocaoStatus(gender, AdocaoStatus.EMPTY));
        }catch (Exception e){
            e.printStackTrace();
        }
        return criancaList;
    }

    public List<Crianca> filterByAge(String age, List<Crianca> criancaList){
        List<Crianca> listFilterByAge = new ArrayList<>();
        for(int i = 0; i < criancaList.size(); i++){
            if(Integer.parseInt(criancaList.get(i).getAge()) <= Integer.parseInt(age)){
                listFilterByAge.add(criancaList.get(i));
            }
        }
        return listFilterByAge;
    }

}
