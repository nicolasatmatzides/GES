package com.adocao.gpms.repository;

import com.adocao.gpms.entity.Duvida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DuvidaRepository extends JpaRepository<Duvida, Long> {

    List<Duvida> findDuvidaByid(Long id);
}
