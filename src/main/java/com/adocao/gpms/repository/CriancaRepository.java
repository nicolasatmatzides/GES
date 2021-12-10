package com.adocao.gpms.repository;

import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.model.AdocaoStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriancaRepository extends JpaRepository<Crianca, Long> {

    List<Crianca> findAllByAdocaoStatus(AdocaoStatus status);

    @Query("select c from Crianca c where c.age <= ?1 and c.gender = ?2")
    List<Crianca> findAllByAgeAndGender(String age, String gender);

}
