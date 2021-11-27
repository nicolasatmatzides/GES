package com.adocao.gpms.security;


import com.adocao.gpms.entity.Usuario;
import com.adocao.gpms.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {


    @Autowired
    private UsuarioService usuarioService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String email = authentication.getName();
        String senha = authentication.getCredentials().toString();

        Optional<Usuario> usuarioOp = usuarioService.getUsuarioByEmail(email);

        if (usuarioOp.isEmpty())
            throw new UsernameNotFoundException("Login e/ou Senha inválidos.");

        Usuario usuario = usuarioOp.get();

        if (!usuario.getPassword().equals(senha))
            throw new BadCredentialsException("Login e/ou Senha inválidos.");

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("US"));

        User springSecurityUser = new User(email, "", grantedAuthorities);

        Authentication auth = new UsernamePasswordAuthenticationToken(springSecurityUser, senha, springSecurityUser.getAuthorities());

        return auth;

    }

    @Override
    public boolean supports(Class<?> auth) {
        return auth.equals(UsernamePasswordAuthenticationToken.class);
    }
}
