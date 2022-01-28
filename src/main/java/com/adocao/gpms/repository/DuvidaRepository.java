package com.adocao.gpms.repository;

import com.adocao.gpms.entity.Duvida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DuvidaRepository extends JpaRepository<Duvida, Long> {

    Duvida findDuvidaById(Long id);
}
