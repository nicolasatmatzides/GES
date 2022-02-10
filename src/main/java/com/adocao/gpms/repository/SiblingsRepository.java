package com.adocao.gpms.repository;

import com.adocao.gpms.entity.Siblings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SiblingsRepository extends JpaRepository<Siblings,Long> {

    @Query("SELECT c.siblings FROM Crianca c WHERE c.id = id")
    List<Siblings> findAllSiblingsByCriancaId (Long id);
}
