package com.adocao.gpms.repository;

import com.adocao.gpms.entity.Crianca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriancaRepository extends JpaRepository<Crianca, Long> {


    List<Crianca> findAllByAdocaoStatus_Empty();

    List<Crianca> findAllByAdocaoStatus_Completed();
}
