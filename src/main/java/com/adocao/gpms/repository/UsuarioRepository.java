package com.adocao.gpms.repository;

import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.entity.Usuario;
import com.adocao.gpms.model.AdocaoStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByEmail(String email);

    List<Usuario> findAll();
}
