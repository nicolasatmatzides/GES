package com.adocao.gpms.service;

import com.adocao.gpms.entity.Usuario;
import com.adocao.gpms.model.login.UsuarioDTO;
import com.adocao.gpms.repository.UsuarioRepository;
import com.adocao.gpms.session.UsuarioLogadoSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioLogadoSession usuarioLogadoSession;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
     Optional<Usuario> user =  usuarioRepository.findByEmail(username);
     user.orElseThrow(() -> new UsernameNotFoundException("Not found" + username));
     UsuarioDTO usuarioDTO = new UsuarioDTO();
     usuarioDTO.setSenha(user.get().getPassword());
     usuarioDTO.setEmail(user.get().getEmail());
     usuarioDTO.setActive(user.get().getActive());
     usuarioLogadoSession.setEmail(user.get().getEmail());
     usuarioLogadoSession.setId(user.get().getId());
     return user.map(UsuarioDTO::new).get();
    }
}
