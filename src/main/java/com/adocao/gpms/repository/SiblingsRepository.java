package com.adocao.gpms.repository;

import com.adocao.gpms.entity.Siblings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SiblingsRepository extends JpaRepository<Siblings,Long> {

    List<Siblings> findAllSiblingsByCriancaId (Long id);
}
