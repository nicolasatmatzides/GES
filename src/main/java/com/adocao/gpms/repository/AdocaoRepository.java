package com.adocao.gpms.repository;

import com.adocao.gpms.entity.Adocao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdocaoRepository extends JpaRepository<Adocao, Long> {

    List<Adocao> findAllCriancaByUsuarioId(Long id);
}
