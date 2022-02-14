package com.adocao.gpms.entity;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@NoArgsConstructor
@Getter
@Entity
@Table(name = "duvida")
public class Duvida {
    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, insertable = false, updatable = false)
    private UUID id;

    @Column(name = "duvida")
    private String duvida;

    @ManyToOne
    @JoinColumn(name = "usuario")
    private Usuario usuario;

    @Column(name = "resposta")
    private String resposta;

}