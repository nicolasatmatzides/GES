package com.adocao.gpms.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioLogadoSession {

    private Long id;

    private String email;

}
