package com.adocao.gpms.service;

import com.adocao.gpms.entity.Usuario;
import com.adocao.gpms.model.login.UsuarioDTO;
import com.adocao.gpms.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     Optional<Usuario> user =  usuarioRepository.findByEmail(username);
     user.orElseThrow(() -> new UsernameNotFoundException("Not found" + username));
     UsuarioDTO usuarioDTO = new UsuarioDTO();
     usuarioDTO.setSenha(user.get().getPassword());
     usuarioDTO.setEmail(user.get().getEmail());
     usuarioDTO.setActive(user.get().getActive());
     return user.map(UsuarioDTO::new).get();
    }
}
