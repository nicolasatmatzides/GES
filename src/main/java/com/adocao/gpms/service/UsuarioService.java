package com.adocao.gpms.service;

import com.adocao.gpms.entity.Crianca;
import com.adocao.gpms.entity.Usuario;
import com.adocao.gpms.model.AdocaoStatus;
import com.adocao.gpms.model.login.UsuarioDTO;
import com.adocao.gpms.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Optional<Usuario> getUsuarioByEmail(String email) {
        return usuarioRepository.findByEmail(email);
    }

    public Optional<Usuario> getUsuarioPorId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario cadastrarUsuario(UsuarioDTO dto, String role) {

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String senha = bcrypt.encode(dto.getSenha());

        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(senha);
        usuario.setRole(role);
        usuario.setName(dto.getUsername());
        usuario.setAge(dto.getAge());
        usuario.setGender(dto.getGender());
        usuario.setAddress(dto.getAddress());
        usuario.setCpf(dto.getCpf());
        usuario.setActive(true);

        return usuarioRepository.save(usuario);
    }

    public Usuario cadastrarUsuarioAdm(UsuarioDTO dto) {
        Usuario usuario = new Usuario();
        usuario.setEmail(dto.getEmail());
        usuario.setPassword(dto.getSenha());
        usuario.setRole("ROLE_ADMIN");
        usuario.setName(dto.getUsername());
        usuario.setAge(dto.getAge());
        usuario.setGender(dto.getGender());
        usuario.setAddress(dto.getAddress());
        usuario.setCpf(dto.getCpf());
        usuario.setActive(true);

        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios() {
        List<Usuario> usuarioList = new ArrayList<>();
        try {
            usuarioList = usuarioRepository.findAll();
        }catch (Exception e){
            e.printStackTrace();
        }
        return usuarioList;
    }
}